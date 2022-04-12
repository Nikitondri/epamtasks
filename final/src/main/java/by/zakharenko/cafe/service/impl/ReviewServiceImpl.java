package by.zakharenko.cafe.service.impl;

import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.dao.helper.DaoHelper;
import by.zakharenko.cafe.dao.helper.DaoHelperFactory;
import by.zakharenko.cafe.dao.impl.dish.DishDao;
import by.zakharenko.cafe.dao.impl.review.ReviewDao;
import by.zakharenko.cafe.entity.Review;
import by.zakharenko.cafe.service.ReviewService;
import by.zakharenko.cafe.service.exception.ServiceException;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    private final DaoHelperFactory daoHelperFactory;

    public ReviewServiceImpl() {
        daoHelperFactory = new DaoHelperFactory();
    }

    @Override
    public List<Review> findReview(String dishIdStr) throws ServiceException {
        try(DaoHelper daoHelper = daoHelperFactory.create()) {
            ReviewDao reviewDao = daoHelper.createReviewDao();
            daoHelper.startTransaction();
            List<Review> listReview = reviewDao.findReviewsByDishId(Integer.parseInt(dishIdStr));
            daoHelper.commit();
            return listReview;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
