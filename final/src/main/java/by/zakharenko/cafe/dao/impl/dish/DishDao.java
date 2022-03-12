package by.zakharenko.cafe.dao.impl.dish;

import by.zakharenko.cafe.dao.Dao;
import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.entity.Dish;

import java.util.List;

public interface DishDao extends Dao<Dish> {
    List<Dish> findByName(String name) throws DaoException;
    List<Dish> findByType(int typeId) throws DaoException;
}
