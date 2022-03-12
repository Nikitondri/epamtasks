package by.zakharenko.cafe.dao.impl.order;

import by.zakharenko.cafe.dao.AbstractDao;
import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.dao.mapper.RowMapper;
import by.zakharenko.cafe.dao.util.SQLDateFormatter;
import by.zakharenko.cafe.entity.Order;
import by.zakharenko.cafe.entity.enumeration.OrderStatus;
import by.zakharenko.cafe.entity.enumeration.PaymentType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {

    private static final String FIND_ALL =
            "SELECT id, user_id, status, cost, payment_type, create_date, desired_time, finished_time, bonuses_used, rating, worker_id FROM order";
    private static final String FIND_BY_ID =
            "SELECT id, user_id, status, cost, payment_type, create_date, desired_time, finished_time, bonuses_used, rating, worker_id FROM order WHERE id=?";
    private static final String INSERT_QUERY =
            "INSERT INTO order(user_id, status, cost, payment_type, create_date, desired_time, finished_time, bonuses_used, rating, worker_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_BY_ID =
            "DELETE FROM order WHERE id = ?";
    private static final String ADD_DISHES =
            "INSERT INTO order_dish(dish_id, count, order_id) VALUES(?, ?, ?);";
    private static final String DELETE_DISHES =
            "DELETE FROM order_dish WHERE dish_id = ? AND order_id = ?";

    public OrderDaoImpl(Connection connection, RowMapper<Order> mapper) {
        super(connection, mapper);
    }

    @Override
    public List<Order> findAll() throws DaoException {
        return executeQuery(FIND_ALL);
    }

    @Override
    public Optional<Order> getById(long id) throws DaoException {
        return executeSingleQuery(FIND_BY_ID, id);
    }

    @Override
    public void insert(Order item) throws DaoException {
        long userId = item.getUserID();
        String orderStatus = item.getOrderStatus().toString();
        double cost = item.getCost();
        String paymentType = item.getPaymentType().toString();
        String createDate = SQLDateFormatter.format(item.getCreateDate());
        String desiredTime = SQLDateFormatter.format(item.getDesiredTime());
        String finishedTime = SQLDateFormatter.format(item.getFinishedTime());
        double bonusesUsed = item.getBonusesUsed();
        int rating = item.getRating();
        long workerId = item.getWorkerId();
        executeParamsUpdate(INSERT_QUERY, userId, orderStatus, cost, paymentType, createDate,
                desiredTime, finishedTime, bonusesUsed, rating, workerId);
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
    public void addDishesToOrder(int dishId, int count, long orderId) throws DaoException {
        executeParamsUpdate(ADD_DISHES, dishId, count, orderId);
    }

    @Override
    public void deleteDishesFromOrder(int dishId, long orderId) throws DaoException {
        executeParamsUpdate(DELETE_DISHES, dishId, orderId);
    }
}
