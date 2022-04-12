package by.zakharenko.cafe.dao.helper;

import by.zakharenko.cafe.dao.connection.ConnectionPool;
import by.zakharenko.cafe.dao.connection.ProxyConnection;
import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.dao.impl.dish.DishDao;
import by.zakharenko.cafe.dao.impl.dish.DishDaoImpl;
import by.zakharenko.cafe.dao.impl.dish_type.DishTypeDao;
import by.zakharenko.cafe.dao.impl.dish_type.DishTypeDaoImpl;
import by.zakharenko.cafe.dao.impl.review.ReviewDao;
import by.zakharenko.cafe.dao.impl.review.ReviewDaoImpl;
import by.zakharenko.cafe.dao.impl.user_account.UserAccountDao;
import by.zakharenko.cafe.dao.impl.user_account.UserAccountDaoImpl;
import by.zakharenko.cafe.entity.Review;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable{
    private final ProxyConnection connection;

    public DaoHelper(ConnectionPool pool) throws DaoException {
        this.connection = pool.getConnection();
    }


    public DishTypeDao createDishTypeDao(){
        return new DishTypeDaoImpl(connection);
    }

    public DishDao createDishDao(){
        return new DishDaoImpl(connection);
    }

    public UserAccountDao createUserAccountDao(){
        return new UserAccountDaoImpl(connection);
    }

    public ReviewDao createReviewDao(){
        return new ReviewDaoImpl(connection);
    }

    public void startTransaction() throws DaoException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    private void rollBack() throws DaoException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void commit() throws DaoException {
        try {
            connection.commit();
        } catch (SQLException e) {
            rollBack();
        }
    }

    @Override
    public void close() throws DaoException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
    }
}
