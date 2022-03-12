package by.zakharenko.cafe.dao.mapper;

import by.zakharenko.cafe.entity.CafeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends CafeEntity> {
    T map(ResultSet resultSet) throws SQLException;
}
