package by.zakharenko.cafe.dao.impl.dish_type;

import by.zakharenko.cafe.dao.AbstractDao;
import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.dao.mapper.RowMapper;
import by.zakharenko.cafe.dao.mapper.impl.DishTypeRowMapper;
import by.zakharenko.cafe.entity.DishType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DishTypeDaoImpl extends AbstractDao<DishType> implements DishTypeDao {

    private static final String FIND_ALL = "SELECT id, name FROM dish_type";
    private static final String FIND_BY_ID = "SELECT id, name FROM dish_type WHERE id = ?";
    private static final String FIND_BY_NAME = "SELECT id, name FROM dish_type WHERE name = ?";
    private static final String INSERT_QUERY = "INSERT INTO dish_type(name) VALUES(?)";
    private static final String DELETE_BY_ID = "DELETE FROM dish_type WHERE id = ?";



    public DishTypeDaoImpl(Connection connection) {
        super(connection, new DishTypeRowMapper());
    }

    @Override
    public List<DishType> findAll() throws DaoException {
        return executeQuery(FIND_ALL);
    }

    @Override
    public Optional<DishType> getById(long id) throws DaoException {
        return executeSingleQuery(FIND_BY_ID, id);
    }

    @Override
    public void insert(DishType item) throws DaoException {
        String name = item.getName();
        executeParamsUpdate(INSERT_QUERY, name);
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
    public Optional<DishType> findByName(String name) throws DaoException {
        return executeSingleQuery(FIND_BY_NAME, name);
    }
}
