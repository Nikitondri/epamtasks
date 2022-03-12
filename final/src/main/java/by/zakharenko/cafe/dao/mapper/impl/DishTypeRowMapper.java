package by.zakharenko.cafe.dao.mapper.impl;

import by.zakharenko.cafe.dao.impl.dish_type.ColumnDishType;
import by.zakharenko.cafe.dao.mapper.RowMapper;
import by.zakharenko.cafe.entity.DishType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishTypeRowMapper implements RowMapper<DishType> {
    @Override
    public DishType map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ColumnDishType.ID.getColumn());
        String name = resultSet.getString(ColumnDishType.NAME.getColumn());
        return new DishType(id, name);
    }
}
