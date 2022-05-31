package by.zakharenko.cafe.service.impl;

import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.dao.helper.DaoHelper;
import by.zakharenko.cafe.dao.helper.DaoHelperFactory;
import by.zakharenko.cafe.dao.impl.user_account.UserAccountDao;
import by.zakharenko.cafe.entity.UserAccount;
import by.zakharenko.cafe.entity.enumeration.UserRole;
import by.zakharenko.cafe.service.UserService;
import by.zakharenko.cafe.service.encryptor.Encryptor;
import by.zakharenko.cafe.service.encryptor.impl.PBKDF2Encryptor;
import by.zakharenko.cafe.service.exception.ServiceException;
import by.zakharenko.cafe.service.validator.Validator;
import by.zakharenko.cafe.service.validator.impl.UserAccountValidator;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final DaoHelperFactory daoHelperFactory;
    private final Encryptor encryptor;

    public UserServiceImpl() {
        daoHelperFactory = new DaoHelperFactory();
        encryptor = new PBKDF2Encryptor();
    }

    @Override
    public void signUp(String login, String password) throws ServiceException {
//        if(!password.equals(repeatPassword)){
//            throw new ServiceException("Passwords do not match");
//        }
        if(!isUniqueLogin(login)){
            throw new ServiceException("This login is already taken");
        }
        Validator<UserAccount> validator = new UserAccountValidator();
        String hashPassword = encryptor.encrypt(password);
        UserAccount userAccount = new UserAccount(login, hashPassword, UserRole.CLIENT, true);
        if(!validator.isValid(userAccount)){
            throw new ServiceException("Incorrect user Account");
        }
        try(DaoHelper daoHelper = daoHelperFactory.create()){
            UserAccountDao userAccountDao = daoHelper.createUserAccountDao();
            userAccountDao.insert(userAccount);
        } catch (DaoException e) {
            throw new ServiceException("Invalid sign up");
        }
    }

    private boolean isUniqueLogin(String login) throws ServiceException {
        try(DaoHelper daoHelper = daoHelperFactory.create()){
            UserAccountDao userAccountDao = daoHelper.createUserAccountDao();
            Optional<UserAccount> userAccount = userAccountDao.findByLogin(login);
            return userAccount.isEmpty();
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public UserAccount findUserByLoginPassword(String password, String login) throws ServiceException {
        String hashPassword = encryptor.encrypt(password);
        try(DaoHelper daoHelper = daoHelperFactory.create()){
            UserAccountDao userAccountDao = daoHelper.createUserAccountDao();
            Optional<UserAccount> userAccount = userAccountDao.findByLoginAndPassword(login, hashPassword);
            if(userAccount.isEmpty()){
                throw new ServiceException("User is not exist");
            }
            return userAccount.get();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
