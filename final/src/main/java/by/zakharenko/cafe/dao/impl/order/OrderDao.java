package by.zakharenko.cafe.dao.impl.order;

import by.zakharenko.cafe.dao.Dao;
import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.entity.Order;

public interface OrderDao extends Dao<Order> {
    void addDishesToOrder(int dishId, int count, long orderId) throws DaoException;
    void deleteDishesFromOrder(int dishId, long orderId) throws DaoException;
}
