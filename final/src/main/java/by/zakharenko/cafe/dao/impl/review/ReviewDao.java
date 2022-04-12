package by.zakharenko.cafe.dao.impl.review;

import by.zakharenko.cafe.dao.Dao;
import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.entity.Review;

import java.util.List;

public interface ReviewDao extends Dao<Review> {
    List<Review> findReviewsByDishId(int dishId) throws DaoException;
}
