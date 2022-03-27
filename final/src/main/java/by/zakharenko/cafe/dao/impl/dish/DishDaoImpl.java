package by.zakharenko.cafe.dao.impl.dish;

import by.zakharenko.cafe.dao.AbstractDao;
import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.dao.mapper.RowMapper;
import by.zakharenko.cafe.entity.Dish;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DishDaoImpl extends AbstractDao<Dish> implements DishDao {
    private static final String FIND_ALL =
            "SELECT id, name, cost, is_enable, type_id, dish_weight, description, picture_path, review_id FROM dish";
    private static final String INSERT_QUERY =
            "INSERT INTO dish(name, cost, is_enable, type_id, dish_weight, description, picture_path, review_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID =
            "SELECT id, name, cost, is_enable, type_id, dish_weight, description, picture_path, review_id FROM dish WHERE ID = ?";
    private static final String DELETE_BY_ID =
            "DELETE FROM dish WHERE id = ?";
    private static final String FIND_BY_NAME =
            "SELECT id, name, cost, is_enable, type_id, dish_weight, description, picture_path, review_id FROM dish WHERE name = ?";
    private static final String FIND_BY_TYPE =
            "SELECT id, name, cost, is_enable, type_id, dish_weight, description, picture_path, review_id FROM dish WHERE type_id = ?";


    public DishDaoImpl(Connection connection, RowMapper<Dish> mapper) {
        super(connection, mapper);
    }

    @Override
    public List<Dish> findAll() throws DaoException {
        return executeQuery(FIND_ALL);
    }

    @Override
    public Optional<Dish> getById(long id) throws DaoException {
        return executeSingleQuery(FIND_BY_ID, id);
    }

    @Override
    public void insert(Dish item) throws DaoException {
        int id = item.getId();
        String name = item.getName();
        Double cost = item.getCost();
        int isEnable = Boolean.compare(item.isEnable(), false);
        int type = item.getType().getId();
        int weight = item.getWeight();
        String description = item.getDescription();
        int reviewId = item.getReviewId();
        executeParamsUpdate(INSERT_QUERY, id, name, cost, isEnable, type, weight, description, reviewId);
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
    public List<Dish> findByName(String name) throws DaoException {
        return executeQuery(FIND_BY_NAME, name);
    }

    @Override
    public List<Dish> findByType(int typeId) throws DaoException {
        return executeQuery(FIND_BY_TYPE, typeId);
    }
}
