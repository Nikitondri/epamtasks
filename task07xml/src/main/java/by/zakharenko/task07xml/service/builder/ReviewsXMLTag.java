package by.zakharenko.task07xml.service.builder;

import by.zakharenko.task07xml.service.exception.ServiceException;

public enum ReviewsXMLTag {
    REVIEW("review"),
    ID("id"),
    DISH("dish"),
    IS_ENABLE("isEnable"),
    DISH_ID("dishId"),
    NAME("name"),
    COST("cost"),
    TYPE("type"),
    TYPE_ID("typeId"),
    TYPE_NAME("typeName"),
    WEIGHT("weight"),
    DESCRIPTION("description"),
    PICTURE_PATH("picturePath"),
    USER("user"),
    ROLE("role"),
    STATUS("status"),
    USER_ID("userId"),
    LOGIN("login"),
    PASSWORD("password"),
    PARENT_ID("parentId"),
    TEXT("text"),
    CREATE_DATE("createDate");

    private final String tag;

    ReviewsXMLTag(String tag) {
        this.tag = tag;
    }

    public String getTagString() {
        return tag;
    }

    public static ReviewsXMLTag getTag(String tag) throws ServiceException {
        return switch (tag){
            case "review" -> REVIEW;
            case "id" -> ID;
            case "dish" -> DISH;
            case "isEnable" -> IS_ENABLE;
            case "dishId" -> DISH_ID;
            case "name" -> NAME;
            case "cost" -> COST;
            case "type" -> TYPE;
            case "typeId" -> TYPE_ID;
            case "typeName" -> TYPE_NAME;
            case "weight" -> WEIGHT;
            case "description" -> DESCRIPTION;
            case "picturePath" -> PICTURE_PATH;
            case "user" -> USER;
            case "role" -> ROLE;
            case "status" -> STATUS;
            case "userId" -> USER_ID;
            case "login" -> LOGIN;
            case "password" -> PASSWORD;
            case "parentId" -> PARENT_ID;
            case "text" -> TEXT;
            case "createDate" -> CREATE_DATE;
            default -> throw new ServiceException("Unexpected value: " + tag);
        };
    }
}
