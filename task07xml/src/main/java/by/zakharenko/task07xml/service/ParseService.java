package by.zakharenko.task07xml.service;

import by.zakharenko.task07xml.entity.Review;
import by.zakharenko.task07xml.service.exception.ServiceException;

import java.io.InputStream;
import java.util.List;

public interface ParseService {
    List<Review> parseDomReview(InputStream inputStream) throws ServiceException;
    List<Review> parseSAXReview(InputStream inputStream) throws ServiceException;
    List<Review> parseStAXReview(InputStream inputStream) throws ServiceException;
}
