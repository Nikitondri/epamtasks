package by.zakharenko.cafe.dao.mapper.impl;

import by.zakharenko.cafe.dao.impl.user_info.ColumnUserInfo;
import by.zakharenko.cafe.dao.mapper.RowMapper;
import by.zakharenko.cafe.dao.util.SQLDateParser;
import by.zakharenko.cafe.entity.Review;
import by.zakharenko.cafe.entity.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UserInfoRowMapper implements RowMapper<UserInfo> {
    @Override
    public UserInfo map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(ColumnUserInfo.ID.getColumn());
        String surname = resultSet.getString(ColumnUserInfo.SURNAME.getColumn());
        String name = resultSet.getString(ColumnUserInfo.NAME.getColumn());
        String phone = resultSet.getString(ColumnUserInfo.PHONE.getColumn());
        String email = resultSet.getString(ColumnUserInfo.EMAIL.getColumn());
        LocalDateTime createDate = SQLDateParser.parse(resultSet.getString(ColumnUserInfo.CREATE_DATE.getColumn()));
        double balance = resultSet.getDouble(ColumnUserInfo.BALANCE.getColumn());
        double bonus = resultSet.getDouble(ColumnUserInfo.BONUS.getColumn());
        return new UserInfo(id, surname, name, phone, email, createDate, balance, bonus);
//        return UserInfo.builder()
//                .withId(id)
//                .withSurname(surname)
//                .withName(name)
//                .withPhone(phone)
//                .withEmail(email)
//                .withCreateDate(createDate)
//                .withBalance(balance)
//                .withBonus(bonus)
//                .build();
    }
}
