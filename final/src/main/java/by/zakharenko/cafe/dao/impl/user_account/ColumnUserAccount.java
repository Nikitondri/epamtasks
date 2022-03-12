package by.zakharenko.cafe.dao.impl.user_account;

public enum ColumnUserAccount {
    ID("id"),
    LOGIN("login"),
    PASSWORD("password"),
    ROLE("role"),
    STATUS("status");
    private final String column;

    ColumnUserAccount(String column){
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}
