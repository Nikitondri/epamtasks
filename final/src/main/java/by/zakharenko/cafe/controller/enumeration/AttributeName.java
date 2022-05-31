package by.zakharenko.cafe.controller.enumeration;

public enum AttributeName {
    DISH_TYPES("dishTypes"),
    DISHES("dishes"),
    DISH("dish"),
    REVIEWS("reviews"),
    USER_ID("userId"),
    LANGUAGE("language"),
    ROLE("role"),
    CURRENT_PAGE("currentPage"),
    INVALIDATE_ATTRIBUTE("invalidate"),
    ERROR("error");

    private final String attribute;

    AttributeName(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
