package by.zakharenko.task07xml.enumeration;

public enum AttributeName {
    REVIEWS("reviews"),
    ERROR("error");

    private final String attribute;

    AttributeName(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
