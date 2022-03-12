package by.zakharenko.task07xml.service.builder;

import by.zakharenko.task07xml.entity.Review;
import by.zakharenko.task07xml.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBuilder {
    protected List<Review> listReview = new ArrayList<>();

    public List<Review> getListReview() {
        return listReview;
    }

    public abstract void buildListReview(String path) throws ServiceException;

}
