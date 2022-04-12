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
import java.util.Optional;

public class MenuServiceImpl implements MenuService {

    private final DaoHelperFactory daoHelperFactory;

    public MenuServiceImpl() {
        daoHelperFactory = new DaoHelperFactory();
    }

    @Override
    public List<DishType> findDishType() throws ServiceException {
        DishTypeDao dishTypeDao;
        try {
            dishTypeDao = new DishTypeDaoImpl(ConnectionPool.getInstance().getConnection());
            return dishTypeDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Dish> findDishes(String dishTypeIdStr) throws ServiceException {
        try(DaoHelper daoHelper = daoHelperFactory.create()) {
            DishDao dishDao = daoHelper.createDishDao();
            DishTypeDao dishTypeDao = daoHelper.createDishTypeDao();
            daoHelper.startTransaction();
            Optional<DishType> dishTypeOptional = dishTypeDao.getById(Long.parseLong(dishTypeIdStr));
            if(dishTypeOptional.isEmpty()) {
                throw new ServiceException("Incorrect dish type id");
            }
            DishType dishType = dishTypeOptional.get();
            List<Dish> result = dishDao.findByType(dishType.getId());
            daoHelper.commit();
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Dish findDish(String dishIdStr) throws ServiceException {
        try(DaoHelper daoHelper = daoHelperFactory.create()){
            DishDao dishDao = daoHelper.createDishDao();
            DishTypeDao dishTypeDao = daoHelper.createDishTypeDao();
            daoHelper.startTransaction();
            Optional<Dish> dishOptional = dishDao.getById(Long.parseLong(dishIdStr));
            if(dishOptional.isEmpty()){
                throw new ServiceException("Incorrect dish id");
            }
            Dish dish = dishOptional.get();
            Optional<DishType> dishTypeOptional = dishTypeDao.getById(dish.getType().getId());
            daoHelper.commit();
            if(dishTypeOptional.isEmpty()){
                throw new ServiceException("Incorrect dish type id");
            }
            dish.setType(dishTypeOptional.get());
            return dish;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
