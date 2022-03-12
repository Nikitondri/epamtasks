package by.zakharenko.cafe.dao.impl.dish_type;

public enum ColumnDishType {
    ID("id"),
    NAME("name");

    private final String column;

    ColumnDishType(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}
