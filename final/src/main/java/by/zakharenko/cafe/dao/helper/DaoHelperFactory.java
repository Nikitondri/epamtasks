package by.zakharenko.cafe.dao.helper;

import by.zakharenko.cafe.dao.connection.ConnectionPool;
import by.zakharenko.cafe.dao.exception.DaoException;

public class DaoHelperFactory {

    public DaoHelper create() throws DaoException {
        return new DaoHelper(ConnectionPool.getInstance());
    }

}
