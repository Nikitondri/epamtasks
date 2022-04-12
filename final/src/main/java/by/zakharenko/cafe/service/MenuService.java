package by.zakharenko.cafe.service;

import by.zakharenko.cafe.entity.Dish;
import by.zakharenko.cafe.entity.DishType;
import by.zakharenko.cafe.service.exception.ServiceException;

import java.util.List;

public interface MenuService {
    List<DishType> findDishType() throws ServiceException;
    List<Dish> findDishes(String dishTypeIdStr) throws ServiceException;
    Dish findDish(String dishIdStr) throws ServiceException;
}
