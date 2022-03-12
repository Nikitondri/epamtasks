package by.zakharenko.cafe.dao.impl.user_account;

import by.zakharenko.cafe.dao.AbstractDao;
import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.dao.mapper.RowMapper;
import by.zakharenko.cafe.entity.UserAccount;
import by.zakharenko.cafe.entity.enumeration.UserRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserAccountDaoImpl extends AbstractDao<UserAccount> implements UserAccountDao {
    private static final String FIND_ALL = "SELECT id, login, password, role, status FROM user_account";
    private static final String FIND_BY_ID = "SELECT id, login, password, role, status FROM user_account WHERE id=";
    private static final String DELETE_BY_ID = "DELETE FROM user_account WHERE id=";
    private static final String INSERT_QUERY = "INSERT INTO user_account(login, password, role, status) VALUES(?, ?, ?, ?)";
    private static final String FIND_BY_LOGIN = "SELECT id, login, password, role, status FROM user_account WHERE login=?";
    private static final String FIND_BY_LOGIN_AND_PASSWORD =
            "SELECT id, login, password, role, status FROM user_account WHERE login=? and password=?";
    private static final String BLOCK_USER = "UPDATE user_account SET status=0 where id=?";
    private static final String UNBLOCK_USER = "UPDATE user_account SET status=1 where id=?";
    private static final String FIND_BY_ROLE = "SELECT id, login, password, role, status FROM user_account WHERE role=?";

    public UserAccountDaoImpl(Connection connection, RowMapper<UserAccount> mapper) {
        super(connection, mapper);
    }

    @Override
    public List<UserAccount> findAll() throws DaoException {
        return executeQuery(FIND_ALL);
    }

    @Override
    public Optional<UserAccount> getById(long id) throws DaoException {
        return executeSingleQuery(FIND_BY_ID + id);
    }

    @Override
    public void insert(UserAccount item) throws DaoException {
        String login = item.getLogin();
        String password = item.getPassword();
        String role = item.getRole().toString();
        int status = Boolean.compare(item.isStatus(), false);
        executeParamsUpdate(INSERT_QUERY, login, password, role, status);
    }

    @Override
    public void removeById(long id) throws DaoException {
        executeUpdate(DELETE_BY_ID + id);
    }

    @Override
    public int getNumRows() throws DaoException {
        try {
            ResultSet resultSet = createStatement(FIND_ALL).executeQuery();
            resultSet.last();
            return resultSet.getRow();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<UserAccount> findByLogin(String login) throws DaoException {
        return executeSingleQuery(FIND_BY_LOGIN, login);
    }

    @Override
    public Optional<UserAccount> findByLoginAndPassword(String login, String password) throws DaoException {
        return executeSingleQuery(FIND_BY_LOGIN_AND_PASSWORD, login, password);
    }

    @Override
    public void blockById(long id) throws DaoException {
        executeParamsUpdate(BLOCK_USER, id);
    }

    @Override
    public void unblockById(long id) throws DaoException {
        executeParamsUpdate(UNBLOCK_USER, id);
    }

    @Override
    public List<UserAccount> findByRole(UserRole role) throws DaoException {
        return executeQuery(FIND_BY_ROLE, role.toString());
    }
}
