package by.zakharenko.cafe.dao.impl.dish;

public enum ColumnDish {
    ID("id"),
    NAME("name"),
    COST("cost"),
    IS_ENABLE("is_enable"),
    TYPE_ID("type_id"),
    WEIGHT("dish_weight"),
    DESCRIPTION("description"),
    PICTURE_PATH("picture_path"),
    REVIEW_ID("review_id");

    private final String column;

    ColumnDish(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}
