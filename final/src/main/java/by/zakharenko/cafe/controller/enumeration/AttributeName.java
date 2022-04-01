package by.zakharenko.cafe.controller.enumeration;

public enum AttributeName {
    DISH_TYPES("dishTypes"),
    DISHES("dishes"),
    ERROR("error");

    private final String attribute;

    AttributeName(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
