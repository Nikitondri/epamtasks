package by.zakharenko.cafe.dao.mapper.impl;

import by.zakharenko.cafe.dao.impl.dish.ColumnDish;
import by.zakharenko.cafe.dao.mapper.RowMapper;
import by.zakharenko.cafe.entity.Dish;
import by.zakharenko.cafe.entity.DishType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishRowMapper implements RowMapper<Dish> {
    @Override
    public Dish map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ColumnDish.ID.getColumn());
        String name = resultSet.getString(ColumnDish.NAME.getColumn());
        double cost = resultSet.getDouble(ColumnDish.COST.getColumn());
        boolean isEnable = resultSet.getInt(ColumnDish.IS_ENABLE.getColumn()) == 1;
        DishType type =  new DishType(resultSet.getInt(ColumnDish.TYPE_ID.getColumn()));
        int weight = resultSet.getInt(ColumnDish.WEIGHT.getColumn());
        String description = resultSet.getString(ColumnDish.DESCRIPTION.getColumn());
        String picturePath = resultSet.getString(ColumnDish.PICTURE_PATH.getColumn());
        int reviewId = resultSet.getInt(ColumnDish.REVIEW_ID.getColumn());
        return new Dish(id, name, cost, isEnable, type, weight, description, picturePath, reviewId);
    }
}
