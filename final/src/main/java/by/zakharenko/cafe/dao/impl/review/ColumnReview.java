package by.zakharenko.cafe.dao.impl.review;

public enum ColumnReview {
    ID("id"),
    DISH_ID("dish_id"),
    USER_ID("user_id"),
    PARENT_ID("parent_id"),
    REVIEW("review");

    private final String column;

    ColumnReview(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}
