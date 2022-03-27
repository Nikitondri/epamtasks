package by.zakharenko.cafe.dao.mapper.impl;

import by.zakharenko.cafe.dao.impl.review.ColumnReview;
import by.zakharenko.cafe.dao.mapper.RowMapper;
import by.zakharenko.cafe.dao.util.SQLDateParser;
import by.zakharenko.cafe.entity.Dish;
import by.zakharenko.cafe.entity.Review;
import by.zakharenko.cafe.entity.UserAccount;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ReviewRowMapper implements RowMapper<Review> {
    @Override
    public Review map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(ColumnReview.ID.getColumn());
        Dish dish = new Dish(resultSet.getInt(ColumnReview.DISH_ID.getColumn()));
        UserAccount user = new UserAccount(resultSet.getLong(ColumnReview.USER_ID.getColumn()));
        Review parent = new Review(resultSet.getLong(ColumnReview.TEXT.getColumn()));
        String text = resultSet.getString(ColumnReview.TEXT.getColumn());
        LocalDateTime createDate = SQLDateParser.parse(resultSet.getString(ColumnReview.CREATE_DATE.getColumn()));
        return new Review(id, dish, user, parent, text, createDate);
    }
}
