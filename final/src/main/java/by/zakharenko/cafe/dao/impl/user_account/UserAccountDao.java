package by.zakharenko.cafe.dao.impl.user_account;

import by.zakharenko.cafe.dao.Dao;
import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.entity.UserAccount;
import by.zakharenko.cafe.entity.enumeration.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserAccountDao extends Dao<UserAccount> {
    Optional<UserAccount> findByLogin(String login) throws DaoException;
    Optional<UserAccount> findByLoginAndPassword(String login, String password) throws DaoException;
    void blockById(long id) throws DaoException;
    void unblockById(long id) throws DaoException;
    List<UserAccount> findByRole(UserRole role) throws DaoException;
}
