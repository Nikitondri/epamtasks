package by.zakharenko.cafe.dao.mapper.impl;

import by.zakharenko.cafe.dao.impl.user_account.ColumnUserAccount;
import by.zakharenko.cafe.dao.mapper.RowMapper;
import by.zakharenko.cafe.entity.UserAccount;
import by.zakharenko.cafe.entity.enumeration.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccountRowMapper implements RowMapper<UserAccount> {
    @Override
    public UserAccount map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(ColumnUserAccount.ID.getColumn());
        String login = resultSet.getString(ColumnUserAccount.LOGIN.getColumn());
        String password = resultSet.getString(ColumnUserAccount.PASSWORD.getColumn());
        UserRole role = UserRole.valueOf(resultSet.getString(ColumnUserAccount.ROLE.getColumn()));
        boolean status = resultSet.getInt(ColumnUserAccount.STATUS.getColumn()) == 1;
        return new UserAccount(id, login, password, role, status);
    }
}
