package by.zakharenko.cafe.controller.enumeration;

public enum Page {
    MENU("/jsp/menu.jsp"),
    ERROR("/jsp/error.jsp"),
    MAIN("/jsp/main.jsp"),
    LOGIN("jsp/login.jsp"),
    DISH_INFO("/jsp/dish_info.jsp");

    private final String value;

    Page(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
