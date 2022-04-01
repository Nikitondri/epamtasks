package by.zakharenko.cafe.dao.impl.dish_type;

import by.zakharenko.cafe.dao.Dao;
import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.entity.DishType;

import java.util.Optional;

public interface DishTypeDao extends Dao<DishType> {
    Optional<DishType> findByName(String name) throws DaoException;
}
