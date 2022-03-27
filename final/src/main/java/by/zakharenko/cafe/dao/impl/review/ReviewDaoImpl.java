package by.zakharenko.cafe.dao.impl.review;

import by.zakharenko.cafe.dao.AbstractDao;
import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.dao.mapper.RowMapper;
import by.zakharenko.cafe.dao.util.SQLDateFormatter;
import by.zakharenko.cafe.entity.Review;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ReviewDaoImpl extends AbstractDao<Review> implements ReviewDao {

    private static final String FIND_ALL = "SELECT id, dish_id, user_id, parent_id, text, create_date FROM review";
    private static final String FIND_BY_ID = "SELECT id, dish_id, user_id, parent_id, text, create_date FROM review WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM review WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO review(dish_id, user_id, parent_id, text, create_date) VALUES(?, ?, ?, ?)";



    public ReviewDaoImpl(Connection connection, RowMapper<Review> mapper) {
        super(connection, mapper);
    }

    @Override
    public List<Review> findAll() throws DaoException {
        return executeQuery(FIND_ALL);
    }

    @Override
    public Optional<Review> getById(long id) throws DaoException {
        return executeSingleQuery(FIND_BY_ID, id);
    }

    @Override
    public void insert(Review item) throws DaoException {
        int dishId = item.getDish().getId();
        long userId = item.getUser().getId();
        long parentId = item.getParent().getId();
        String createDate = SQLDateFormatter.format(item.getCreateDate());
        String text = item.getText();
        executeParamsUpdate(INSERT_QUERY, dishId, userId, parentId, text, createDate);
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
}
