package by.zakharenko.cafe.dao.impl.user_info;

public enum ColumnUserInfo {
    ID("id"),
    SURNAME("surname"),
    NAME("name"),
    PHONE("phone"),
    EMAIL("email"),
    CREATE_DATE("create_date"),
    BALANCE("balance"),
    BONUS("bonus");

    private final String column;

    ColumnUserInfo(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}
