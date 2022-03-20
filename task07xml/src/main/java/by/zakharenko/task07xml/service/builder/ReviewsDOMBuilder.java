package by.zakharenko.task07xml.service.builder;


import by.zakharenko.task07xml.entity.Dish;
import by.zakharenko.task07xml.entity.DishType;
import by.zakharenko.task07xml.entity.Review;
import by.zakharenko.task07xml.entity.UserAccount;
import by.zakharenko.task07xml.entity.enumeration.UserRole;
import by.zakharenko.task07xml.service.exception.ServiceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

public class ReviewsDOMBuilder extends AbstractBuilder{
    private final DocumentBuilder docBuilder;

    public ReviewsDOMBuilder() throws ServiceException {
        try {
            docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ServiceException("parser configuration error");
        }
    }

    @Override
    public void buildListReview(InputStream inputStream) throws ServiceException {
        try {
            Document document = docBuilder.parse(inputStream);
            Element root = document.getDocumentElement();
            NodeList nodeList = root.getChildNodes();
            for(int i = 0; i < nodeList.getLength(); i++){
                if(nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodeList.item(i);
                    listReview.add(buildReview(element));
                }
            }
        } catch (SAXException e) {
            throw new ServiceException("Parsing failure: " + e);
        } catch (IOException e) {
            throw new ServiceException("I/O Error: " + e);
        }
    }

    private Review buildReview(Element reviewElement){
        long id = Long.parseLong(getElementStringContent(reviewElement, "id"));
        Dish dish = buildDish((Element) reviewElement.getElementsByTagName("dish").item(0));
        UserAccount userAccount = buildUserAccount((Element) reviewElement.getElementsByTagName("user").item(0));
        Review parent = buildParentReview(Long.parseLong(getElementStringContent(reviewElement, "parentId")));
        String text = getElementStringContent(reviewElement, "text");
        LocalDateTime dateTime = LocalDateTime.parse(getElementStringContent(reviewElement, "createDate"));
        return Review.builder()
                .withId(id)
                .withDish(dish)
                .withUser(userAccount)
                .withParent(parent)
                .withText(text)
                .withDateTime(dateTime)
                .build();
    }

    private Review buildParentReview(long parentId){
        for(Review review : listReview){
            if(review.getId() == parentId){
                return review;
            }
        }
        return null;
    }

    private UserAccount buildUserAccount(Element userElement){
        long userId = Long.parseLong(getElementStringContent(userElement, "userId"));
        for(Review review : listReview){
            if(review.getUser().getId() == userId){
                return review.getUser();
            }
        }
        boolean status;
        if(userElement.hasAttribute("status")){
            status = Integer.parseInt(userElement.getAttribute("status")) == 1;
        } else {
            status = true;
        }
        return new UserAccount(
                userId,
                getElementStringContent(userElement, "login"),
                getElementStringContent(userElement, "password"),
//                UserRole.valueOf(getElementStringContent(userElement, "role")),
                UserRole.valueOf(userElement.getAttribute("role")),
//                Integer.parseInt(getElementStringContent(userElement, "status")) == 1
                status
        );
    }

    private Dish buildDish(Element dishElement){
        int dishId = Integer.parseInt(getElementStringContent(dishElement, "dishId"));
        for(Review review : listReview){
            if(review.getDish().getId() == dishId){
                return review.getDish();
            }
        }
        boolean isEnable;
        if(dishElement.hasAttribute("isEnable")){
            isEnable = Integer.parseInt(dishElement.getAttribute("isEnable")) == 1;
        } else {
            isEnable = true;
        }
        return new Dish(
                dishId,
                getElementStringContent(dishElement, "name"),
                Double.parseDouble(getElementStringContent(dishElement, "cost")),
//                Integer.parseInt(getElementStringContent(dishElement, "isEnable")) == 1,
                isEnable,
                buildDishType((Element) dishElement.getElementsByTagName("type").item(0)),
                Integer.parseInt(getElementStringContent(dishElement, "weight")),
                getElementStringContent(dishElement, "description"),
                getElementStringContent(dishElement, "picturePath")
        );
    }

    private DishType buildDishType(Element dishTypeElement){
        return new DishType(
                Integer.parseInt(getElementStringContent(dishTypeElement, "typeId")),
                getElementStringContent(dishTypeElement, "typeName")
        );
    }

    private String getElementStringContent(Element reviewElement, String elementName){
        return reviewElement.getElementsByTagName(elementName).item(0).getTextContent();
    }
}
