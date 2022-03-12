package by.zakharenko.cafe.entity;

import java.util.Objects;

public class Review extends CafeEntity{
    private final long id;
    private final int dishId;
    private final long userId;
    private final long parentId;
    private final String text;

    public Review(long id, int dishId, long userId, long parentId, String text) {
        this.id = id;
        this.dishId = dishId;
        this.userId = userId;
        this.parentId = parentId;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public int getDishId() {
        return dishId;
    }

    public long getUserId() {
        return userId;
    }

    public long getParentId() {
        return parentId;
    }

    public String getText() {
        return text;
    }

    public static Builder builder(){
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && dishId == review.dishId && userId == review.userId && parentId == review.parentId && Objects.equals(text, review.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dishId, userId, parentId, text);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", dishId=" + dishId +
                ", userId=" + userId +
                ", parentId=" + parentId +
                ", text='" + text + '\'' +
                '}';
    }

    public static class Builder{
        private long id;
        private int dishId;
        private long userId;
        private long parentId;
        private String text;

        private Builder(){}

        public Builder withId(long id){
            this.id = id;
            return this;
        }

        public Builder withDishId(int dishId){
            this.dishId = dishId;
            return this;
        }

        public Builder withUserId(long userId){
            this.userId = userId;
            return this;
        }

        public Builder withParentId(long parentId){
            this.parentId = parentId;
            return this;
        }

        public Builder withText(String text){
            this.text = text;
            return this;
        }

        public Review build(){
            return new Review(this.id, this.dishId, this.userId, this.parentId, this.text);
        }
    }
}
