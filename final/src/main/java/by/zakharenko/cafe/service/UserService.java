package by.zakharenko.cafe.service;

import by.zakharenko.cafe.entity.UserAccount;
import by.zakharenko.cafe.service.exception.ServiceException;

public interface UserService {
    void signUp(String login, String password) throws ServiceException;
    UserAccount findUserByLoginPassword(String password, String login) throws ServiceException;
}
