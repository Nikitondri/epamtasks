package by.zakharenko.cafe.service.impl;

import by.zakharenko.cafe.dao.connection.ConnectionPool;
import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.dao.helper.DaoHelper;
import by.zakharenko.cafe.dao.helper.DaoHelperFactory;
import by.zakharenko.cafe.dao.impl.dish.DishDao;
import by.zakharenko.cafe.dao.impl.dish_type.DishTypeDao;
import by.zakharenko.cafe.dao.impl.dish_type.DishTypeDaoImpl;
import by.zakharenko.cafe.entity.Dish;
import by.zakharenko.cafe.entity.DishType;
import by.zakharenko.cafe.service.MenuService;
import by.zakharenko.cafe.service.exception.ServiceException;

import java.util.List;

public class MenuServiceImpl implements MenuService {

    private final DaoHelperFactory daoHelperFactory;

    public MenuServiceImpl() {
        daoHelperFactory = new DaoHelperFactory();
    }

    @Override
    public List<DishType> goToMenu() throws ServiceException {
        DishTypeDao dishTypeDao;
        try {
            dishTypeDao = new DishTypeDaoImpl(ConnectionPool.getInstance().getConnection());
            return dishTypeDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Dish> showDishes(String dishTypeIdStr) throws ServiceException {
        try(DaoHelper daoHelper = daoHelperFactory.create()) {
            DishDao dishDao = daoHelper.createDishDao();
            DishTypeDao dishTypeDao = daoHelper.createDishTypeDao();
            daoHelper.startTransaction();
            DishType dishType = dishTypeDao.getById(Long.parseLong(dishTypeIdStr)).get();
//            DishType dishType = dishTypeDao.findByName(name).get();
            List<Dish> result = dishDao.findByType(dishType.getId());
            daoHelper.commit();
            return result;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
