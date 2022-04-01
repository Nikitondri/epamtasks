package by.zakharenko.cafe.service;

import by.zakharenko.cafe.entity.Dish;
import by.zakharenko.cafe.entity.DishType;
import by.zakharenko.cafe.service.exception.ServiceException;

import java.util.List;

public interface MenuService {
    List<DishType> goToMenu() throws ServiceException;
    List<Dish> showDishes(String dishTypeIdStr) throws ServiceException;
}
