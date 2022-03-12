package by.zakharenko.cafe.dao.impl.order;

public enum ColumnOrder {
    ID("id"),
    USER_ID("user_id"),
    STATUS("status"),
    COST("cost"),
    PAYMENT_TYPE("payment_type"),
    CREATE_DATE("create_date"),
    DESIRED_TIME("desired_time"),
    FINISHED_TIME("finished_time"),
    BONUSES_USED("bonuses_used"),
    RATING("rating"),
    WORKER_ID("worker_id");

    private final String column;

    ColumnOrder(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}
