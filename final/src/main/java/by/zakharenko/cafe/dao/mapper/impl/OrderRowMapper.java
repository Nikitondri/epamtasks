package by.zakharenko.cafe.dao.mapper.impl;

import by.zakharenko.cafe.dao.impl.order.ColumnOrder;
import by.zakharenko.cafe.dao.mapper.RowMapper;
import by.zakharenko.cafe.dao.util.SQLDateParser;
import by.zakharenko.cafe.entity.Order;
import by.zakharenko.cafe.entity.UserAccount;
import by.zakharenko.cafe.entity.enumeration.OrderStatus;
import by.zakharenko.cafe.entity.enumeration.PaymentType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(ColumnOrder.ID.getColumn());
        UserAccount user = new UserAccount(resultSet.getLong(ColumnOrder.USER_ID.getColumn()));
        OrderStatus orderStatus = OrderStatus.valueOf(resultSet.getString(ColumnOrder.STATUS.getColumn()));
        double cost = resultSet.getDouble(ColumnOrder.COST.getColumn());
        PaymentType paymentType = PaymentType.valueOf(resultSet.getString(ColumnOrder.PAYMENT_TYPE.getColumn()));
        LocalDateTime createDate = SQLDateParser.parse(resultSet.getString(ColumnOrder.CREATE_DATE.getColumn()));
        LocalDateTime desiredTime = SQLDateParser.parse(resultSet.getString(ColumnOrder.DESIRED_TIME.getColumn()));
        LocalDateTime finishedTime = SQLDateParser.parse(resultSet.getString(ColumnOrder.FINISHED_TIME.getColumn()));
        double bonusesUsed = resultSet.getDouble(ColumnOrder.BONUSES_USED.getColumn());
        int rating = resultSet.getInt(ColumnOrder.RATING.getColumn());
        UserAccount workerId = new UserAccount(resultSet.getLong(ColumnOrder.WORKER_ID.getColumn()));
        return new Order(
                id, user, orderStatus, cost, paymentType, createDate, desiredTime, finishedTime,
                bonusesUsed, rating, workerId
        );
    }
}
