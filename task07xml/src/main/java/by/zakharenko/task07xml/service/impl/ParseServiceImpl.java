package by.zakharenko.task07xml.service.impl;

import by.zakharenko.task07xml.entity.Review;
import by.zakharenko.task07xml.service.ParseService;
import by.zakharenko.task07xml.service.builder.AbstractBuilder;
import by.zakharenko.task07xml.service.builder.ReviewsDOMBuilder;
import by.zakharenko.task07xml.service.builder.ReviewsSAXBuilder;
import by.zakharenko.task07xml.service.builder.ReviewsStAXBuilder;
import by.zakharenko.task07xml.service.exception.ServiceException;
import by.zakharenko.task07xml.service.validator.ValidatorXML;

import java.io.*;
import java.util.List;

public class ParseServiceImpl implements ParseService {
    private static final String SCHEMA_PATH = "xml/reviews.xsd";

    @Override
    public List<Review> parseDomReview(InputStream inputStream) throws ServiceException {
        return findDataParse(inputStream, new ReviewsDOMBuilder());
    }

    @Override
    public List<Review> parseSAXReview(InputStream inputStream) throws ServiceException {
        return findDataParse(inputStream, new ReviewsSAXBuilder());
    }

    @Override
    public List<Review> parseStAXReview(InputStream inputStream) throws ServiceException {
        return findDataParse(inputStream, new ReviewsStAXBuilder());
    }

    private List<Review> findDataParse(InputStream inputStream, AbstractBuilder parser) throws ServiceException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ValidatorXML validator = new ValidatorXML();
        try {
            inputStream.transferTo(byteArray);
        } catch (IOException e) {
            throw new ServiceException("findDataParse: " + e);
        }
        validator.validateXMLFile(new ByteArrayInputStream(byteArray.toByteArray()), SCHEMA_PATH);
        parser.buildListReview(new ByteArrayInputStream(byteArray.toByteArray()));
        return parser.getListReview();
    }
}
