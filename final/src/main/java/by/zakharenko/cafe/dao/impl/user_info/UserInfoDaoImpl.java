package by.zakharenko.cafe.dao.impl.user_info;

import by.zakharenko.cafe.dao.AbstractDao;
import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.dao.mapper.RowMapper;
import by.zakharenko.cafe.dao.util.SQLDateFormatter;
import by.zakharenko.cafe.entity.UserInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class UserInfoDaoImpl extends AbstractDao<UserInfo> implements UserInfoDao {

    private static final String FIND_ALL =
            "SELECT id, surname, name, phone, email, create_date, balance, bonus FROM user_info";
    private static final String FIND_BY_ID =
            "SELECT id, surname, name, phone, email, create_date, balance, bonus FROM user_info WHERE id=?";
    private static final String INSERT_QUERY =
            "INSERT INTO user_info(id, surname, name, phone, email, create_date, balance, bonus) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_BY_ID =
            "DELETE FROM user_info WHERE id=?";
    private static final String FIND_BETWEEN_DATE =
            "SELECT id, surname, name, phone, email, create_date, balance, bonus FROM user_info WHERE create_date BETWEEN ? and ?";
    private static final String FIND_AFTER_DATE =
            "SELECT id, surname, name, phone, email, create_date, balance, bonus FROM user_info WHERE create_date > ?";
    private static final String FIND_BEFORE_DATE =
            "SELECT id, surname, name, phone, email, create_date, balance, bonus FROM user_info WHERE create_date < ?";
    private static final String ADD_BONUS =
            "UPDATE user_info SET bonus = bonus + ? WHERE id = ?";
    private static final String WRITE_OFF_BONUS =
            "UPDATE user_info SET bonus = bonus - ? WHERE id = ?";
    private static final String ADD_BALANCE =
            "UPDATE user_info SET balance = balance + ? WHERE id = ?";
    private static final String WRITE_OFF_BALANCE =
            "UPDATE user_info SET balance = balance - ? WHERE id = ?";


    protected UserInfoDaoImpl(Connection connection, RowMapper<UserInfo> mapper) {
        super(connection, mapper);
    }

    @Override
    public List<UserInfo> findAll() throws DaoException {
        return executeQuery(FIND_ALL);
    }

    @Override
    public Optional<UserInfo> getById(long id) throws DaoException {
        return executeSingleQuery(FIND_BY_ID, id);
    }

    @Override
    public void insert(UserInfo item) throws DaoException {
        long id = item.getId();
        String surname = item.getSurname();
        String name = item.getName();
        String phone = item.getPhone();
        String email = item.getEmail();
        String createDate = SQLDateFormatter.format(item.getCreateDate());
        double balance = item.getBalance();
        double bonus = item.getBonus();
        executeParamsUpdate(INSERT_QUERY, id, surname, name, phone, email, createDate, balance, bonus);
    }

    @Override
    public void removeById(long id) throws DaoException {
        executeParamsUpdate(DELETE_BY_ID, id);
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
    public List<UserInfo> findBetweenDate(LocalDateTime afterDate, LocalDateTime beforeDate) throws DaoException {
        return executeQuery(FIND_BETWEEN_DATE, afterDate, beforeDate);
    }

    @Override
    public List<UserInfo> findBeforeDate(LocalDateTime date) throws DaoException{
        return executeQuery(FIND_BEFORE_DATE, date);
    }

    @Override
    public List<UserInfo> findAfterDate(LocalDateTime date) throws DaoException {
        return executeQuery(FIND_AFTER_DATE, date);
    }

    @Override
    public void addBonus(double bonus, long id) throws DaoException {
        executeParamsUpdate(ADD_BONUS, bonus, id);
    }

    @Override
    public void writeOffBonus(double bonus, long id) throws DaoException {
        executeParamsUpdate(WRITE_OFF_BONUS, bonus, id);
    }

    @Override
    public void addBalance(double balance, long id) throws DaoException {
        executeParamsUpdate(ADD_BALANCE, balance, id);
    }

    @Override
    public void writeOffBalance(double balance, long id) throws DaoException {
        executeParamsUpdate(WRITE_OFF_BALANCE, balance, id);
    }
}
