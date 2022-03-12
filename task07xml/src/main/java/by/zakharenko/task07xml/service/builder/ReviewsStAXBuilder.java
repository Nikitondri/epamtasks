package by.zakharenko.task07xml.service.builder;

import by.zakharenko.task07xml.entity.Dish;
import by.zakharenko.task07xml.entity.DishType;
import by.zakharenko.task07xml.entity.Review;
import by.zakharenko.task07xml.entity.UserAccount;
import by.zakharenko.task07xml.entity.enumeration.UserRole;
import by.zakharenko.task07xml.service.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReviewsStAXBuilder extends AbstractBuilder{
    static final Logger LOGGER = LogManager.getLogger(ReviewsStAXBuilder.class.getName());
    private final XMLInputFactory inputFactory;

    public ReviewsStAXBuilder(){
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildListReview(String path) throws ServiceException {
        try{
            FileInputStream input = new FileInputStream(path);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            while(reader.hasNext()){
                int type = reader.next();
                if(type == XMLStreamConstants.START_ELEMENT){
                    String name = reader.getLocalName();
                    if(name.equals(ReviewsXMLTag.REVIEW.getTagString())){
                        Review review = buildReview(reader);
                        listReview.add(review);
                    }
                }
            }
        } catch (IOException | XMLStreamException e) {
            throw new ServiceException(e);
        }
    }

    private Review buildReview(XMLStreamReader reader) throws XMLStreamException, ServiceException {
        Review.Builder builder = Review.builder();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            if(type == XMLStreamConstants.START_ELEMENT){
                name = reader.getLocalName();
                switch (ReviewsXMLTag.getTag(name)) {
                    case ID -> builder.withId(Long.parseLong(getXMLText(reader)));
                    case DISH -> builder.withDish(buildDish(reader));
                    case USER -> builder.withUser(buildUser(reader));
                    case PARENT_ID -> builder.withParent(findParent(Long.parseLong(getXMLText(reader))));
                    case TEXT -> builder.withText(getXMLText(reader));
                    case CREATE_DATE -> builder.withDateTime(LocalDateTime.parse(getXMLText(reader)));
                    default -> LOGGER.log(Level.ERROR, "Unknown element in tag review");
                }
            } else if(type == XMLStreamConstants.END_ELEMENT) {
                name = reader.getLocalName();
                if (name.equals(ReviewsXMLTag.REVIEW.getTagString())) {
                    return builder.build();
                }
            }
        }
        throw new ServiceException("Unknown element in tag review");
    }

    private Dish buildDish(XMLStreamReader reader) throws XMLStreamException, ServiceException {
        Dish dish = new Dish();
        int type;
        String name;
        if(reader.getAttributeCount() == 1){
            dish.setEnable(Integer.parseInt(reader.getAttributeValue(null, ReviewsXMLTag.IS_ENABLE.getTagString())) == 1);
        } else {
            dish.setEnable(true);
        }
        while(reader.hasNext()){
            type = reader.next();
            if(type == XMLStreamConstants.START_ELEMENT){
                name = reader.getLocalName();
                switch (ReviewsXMLTag.getTag(name)) {
                    case DISH_ID -> dish.setId(Integer.parseInt(getXMLText(reader)));
                    case NAME -> dish.setName(getXMLText(reader));
                    case COST -> dish.setCost(Double.parseDouble(getXMLText(reader)));
                    case TYPE -> dish.setTypeId(buildDishType(reader));
                    case WEIGHT -> dish.setWeight(Integer.parseInt(getXMLText(reader)));
                    case DESCRIPTION -> dish.setDescription(getXMLText(reader));
                    case PICTURE_PATH -> dish.setPicturePath(getXMLText(reader));
                    default -> LOGGER.log(Level.ERROR, "Unknown element in tag dish");
                }
            } else if(type == XMLStreamConstants.END_ELEMENT) {
                name = reader.getLocalName();
                if (name.equals(ReviewsXMLTag.DISH.getTagString())) {
                    return findDish(dish);
                }
            }
        }

        throw new ServiceException("Unknown element in tag dish");
    }

    private DishType buildDishType(XMLStreamReader reader) throws XMLStreamException, ServiceException {
        DishType dishType = new DishType();
        String name;
        int type;
        while (reader.hasNext()){
            type = reader.next();
            if(type == XMLStreamConstants.START_ELEMENT){
                name = reader.getLocalName();
                switch (ReviewsXMLTag.getTag(name)) {
                    case TYPE_ID -> dishType.setId(Integer.parseInt(getXMLText(reader)));
                    case TYPE_NAME -> dishType.setName(getXMLText(reader));
                    default -> LOGGER.log(Level.ERROR, "Unknown element in tag dishType");
                }
            } else if(type == XMLStreamConstants.END_ELEMENT) {
                name = reader.getLocalName();
                if (name.equals(ReviewsXMLTag.TYPE.getTagString())) {
                    return findDishType(dishType);
                }
            }
        }
        throw new ServiceException("Unknown element in tag dishType");
    }

    private UserAccount buildUser(XMLStreamReader reader) throws XMLStreamException, ServiceException {
        UserAccount user = new UserAccount();
        String name;
        int type;
        user.setRole(UserRole.valueOf(reader.getAttributeValue(null, ReviewsXMLTag.ROLE.getTagString())));
        if(reader.getAttributeCount() == 2){
            user.setStatus(Integer.parseInt(reader.getAttributeValue(null, ReviewsXMLTag.STATUS.getTagString())) == 1);
        } else {
            user.setStatus(true);
        }
        while (reader.hasNext()){
            type = reader.next();
            if(type == XMLStreamConstants.START_ELEMENT){
                name = reader.getLocalName();
                switch (ReviewsXMLTag.getTag(name)) {
                    case USER_ID -> user.setId(Long.parseLong(getXMLText(reader)));
                    case LOGIN -> user.setLogin(getXMLText(reader));
                    case PASSWORD -> user.setPassword(getXMLText(reader));
                    default -> LOGGER.log(Level.ERROR, "Unknown element in tag user");
                }
            } else if(type == XMLStreamConstants.END_ELEMENT) {
                name = reader.getLocalName();
                if (name.equals(ReviewsXMLTag.USER.getTagString())) {
                    return findUser(user);
                }
            }
        }
        throw new ServiceException("Unknown element in tag user");
    }


    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if(reader.hasNext()){
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private Dish findDish(Dish dish){
        int dishId = dish.getId();
        for(Review review : listReview) {
            if(dishId == review.getDish().getId()){
                return review.getDish();
            }
        }
        return dish;
    }

    private Review findParent(long parentId){
        for(Review review : listReview){
            if(review.getId() == parentId){
                return review;
            }
        }
        return null;
    }

    private UserAccount findUser(UserAccount userAccount){
        long id = userAccount.getId();
        for(Review review : listReview) {
            if(id == review.getUser().getId()){
                return review.getUser();
            }
        }
        return userAccount;
    }

    private DishType findDishType(DishType dishType){
        int id = dishType.getId();
        for(Review review : listReview) {
            if(id == review.getDish().getTypeId().getId()){
                return review.getDish().getTypeId();
            }
        }
        return dishType;
    }
}
