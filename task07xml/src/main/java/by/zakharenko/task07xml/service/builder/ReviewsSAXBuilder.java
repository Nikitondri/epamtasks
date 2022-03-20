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
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReviewsSAXBuilder extends AbstractBuilder{

    static final Logger LOGGER = LogManager.getLogger(ReviewsSAXBuilder.class.getName());
    private final ReviewsHandler reviewsHandler;
    private final SAXParserFactory factory = SAXParserFactory.newInstance();

    public ReviewsSAXBuilder(){
        reviewsHandler = new ReviewsHandler();
    }

    @Override
    public void buildListReview(InputStream inputStream) throws ServiceException {
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(inputStream, reviewsHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new ServiceException(e);
        }
        listReview = reviewsHandler.getListReview();
    }

    private static class ReviewsHandler extends DefaultHandler {
        private final List<Review> listReview;
        private Review.Builder builder;
        private Dish dish;
        private DishType dishType;
        private UserAccount userAccount;
        private String content;

        public ReviewsHandler(){
            listReview = new ArrayList<>();
        }

        public List<Review> getListReview() {
            return this.listReview;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (ReviewsXMLTag.DISH.getTagString().equals(qName)) {
                dish = new Dish();
                if (attributes.getLength() == 1) {
                    dish.setEnable(Integer.parseInt(attributes.getValue(0)) == 1);
                } else {
                    dish.setEnable(true);
                }
            } else if(ReviewsXMLTag.USER.getTagString().equals(qName)) {
                userAccount = new UserAccount();
                userAccount.setRole(UserRole.valueOf(attributes.getValue(ReviewsXMLTag.ROLE.getTagString())));
                if(attributes.getLength() == 2){
                    userAccount.setStatus(Integer.parseInt(attributes.getValue(ReviewsXMLTag.STATUS.getTagString())) == 1);
                } else {
                    userAccount.setStatus(true);
                }
            } else if(ReviewsXMLTag.TYPE.getTagString().equals(qName)){
                dishType = new DishType();
            } else if(ReviewsXMLTag.REVIEW.getTagString().equals(qName)){
                builder = Review.builder();
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if(qName.equals(ReviewsXMLTag.ID.getTagString())){
                builder.withId(Long.parseLong(content));
            }
            if(qName.equals(ReviewsXMLTag.DISH.getTagString())){
                builder.withDish(dish);
            }
            switch (qName){
                case "review" -> listReview.add(builder.build());
                case "id" -> builder.withId(Long.parseLong(content));
                case "dish" -> builder.withDish(findDish(dish));
                case "dishId" -> dish.setId(Integer.parseInt(content));
                case "name" -> dish.setName(content);
                case "cost" -> dish.setCost(Double.parseDouble(content));
                case "type" -> dish.setTypeId(findDishType(dishType));
                case "typeId" -> dishType.setId(Integer.parseInt(content));
                case "typeName" -> dishType.setName(content);
                case "weight" -> dish.setWeight(Integer.parseInt(content));
                case "description" -> dish.setDescription(content);
                case "picturePath" -> dish.setPicturePath(content);
                case "user" -> builder.withUser(findUser(userAccount));
                case "userId" -> userAccount.setId(Long.parseLong(content));
                case "login" -> userAccount.setLogin(content);
                case "password" -> userAccount.setPassword(content);
                case "parentId" -> builder.withParent(findParent(Long.parseLong(content)));
                case "text" -> builder.withText(content);
                case "createDate" -> builder.withDateTime(LocalDateTime.parse(content));
                default -> LOGGER.log(Level.ERROR, "Unknown element in tag review");
            }

        }

        @Override
        public void characters(char[] ch, int start, int length) {
            content = new String(ch, start, length).trim();
        }

        private Review findParent(long parentId){
            for(Review review : listReview){
                if(review.getId() == parentId){
                    return review;
                }
            }
            return null;
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
}
