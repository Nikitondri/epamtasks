package by.zakharenko.cafe.dao;

import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.dao.mapper.RowMapper;
import by.zakharenko.cafe.entity.CafeEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends CafeEntity> implements Dao<T> {
    private final Connection connection;
    private final RowMapper<T> mapper;

    protected AbstractDao(Connection connection, RowMapper<T> mapper) {
        this.connection = connection;
        this.mapper = mapper;
    }

    protected PreparedStatement createStatement(String query, Object... params) throws DaoException {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for(int i = 1; i < params.length; i++){
                statement.setObject(i, params[i - 1]);
            }
            return statement;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    protected void executeUpdate(String query) throws DaoException {
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    protected List<T> executeQuery(String query, Object... params) throws DaoException {
        try(PreparedStatement statement = createStatement(query, params)){
            ResultSet resultSet = statement.executeQuery();
            List<T> entities = new ArrayList<>();
            while(resultSet.next()){
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    protected void executeParamsUpdate(String query, Object... params) throws DaoException {
        try (PreparedStatement preparedStatement = createStatement(query, params)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    protected Optional<T> executeSingleQuery(String query, Object... params) throws DaoException {
        List<T> items = executeQuery(query, params);
        if (items.size() == 1) {
            return Optional.of(items.get(0));
        } else if (items.size() > 1) {
            throw new DaoException("More than one record found.");
        } else {
            return Optional.empty();
        }
    }

}
