package by.zakharenko.task07xml.enumeration;

public enum Page {
    RESULT("/jsp/result.jsp"),
    ERROR("/jsp/error.jsp");

    private final String value;

    Page(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
