package by.zakharenko.cafe.controller;


import by.zakharenko.cafe.dao.connection.ConnectionPool;
import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.dao.helper.DaoHelper;
import by.zakharenko.cafe.dao.helper.DaoHelperFactory;
import by.zakharenko.cafe.dao.impl.dish.DishDao;
import by.zakharenko.cafe.dao.impl.dish_type.DishTypeDao;
import by.zakharenko.cafe.dao.impl.dish_type.DishTypeDaoImpl;
import by.zakharenko.cafe.dao.impl.user_account.UserAccountDao;
import by.zakharenko.cafe.dao.impl.user_account.UserAccountDaoImpl;
import by.zakharenko.cafe.entity.DishType;
import by.zakharenko.cafe.entity.enumeration.UserRole;
import by.zakharenko.cafe.service.exception.ServiceException;

import java.util.List;

public class Runner {
    public static void main(String[] args) throws ServiceException, DaoException {
        DaoHelperFactory daoHelperFactory = new DaoHelperFactory();
        DaoHelper daoHelper = daoHelperFactory.create();
        DishTypeDao dishTypeDao = daoHelper.createDishTypeDao();
        DishDao dishDao = daoHelper.createDishDao();
        UserAccountDao userAccountDao = daoHelper.createUserAccountDao();
        daoHelper.startTransaction();
//        dishTypeDao.findByName("HOT");
        System.out.println(dishTypeDao.findByName("HOT").get().getId());
        daoHelper.commit();
//        System.out.println(list);
    }
}
