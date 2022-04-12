package by.zakharenko.cafe.service;

import by.zakharenko.cafe.entity.Review;
import by.zakharenko.cafe.service.exception.ServiceException;

import java.util.List;

public interface ReviewService {
    List<Review> findReview(String dishIdStr) throws ServiceException;
}
