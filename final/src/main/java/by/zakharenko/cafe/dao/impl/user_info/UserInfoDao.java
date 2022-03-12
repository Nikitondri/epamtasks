package by.zakharenko.cafe.dao.impl.user_info;

import by.zakharenko.cafe.dao.Dao;
import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.entity.UserInfo;

import java.time.LocalDateTime;
import java.util.List;

public interface UserInfoDao extends Dao<UserInfo> {
    List<UserInfo> findBetweenDate(LocalDateTime afterDate, LocalDateTime beforeDate) throws DaoException;

    List<UserInfo> findBeforeDate(LocalDateTime date) throws DaoException;

    List<UserInfo> findAfterDate(LocalDateTime date) throws DaoException;

    void addBonus(double bonus, long id) throws DaoException;

    void writeOffBonus(double bonus, long id) throws DaoException;

    void addBalance(double balance, long id) throws DaoException;

    void writeOffBalance(double balance, long id) throws DaoException;
}