package by.zakharenko.cafe.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Review extends CafeEntity{
    private final long id;
    private Dish dish;
    private UserAccount user;
    private Review parent;
    private String text;
    private LocalDateTime createDate;

    public Review(long id, Dish dish, UserAccount user, Review parent, String text, LocalDateTime createDate) {
        this.id = id;
        this.dish = dish;
        this.user = user;
        this.parent = parent;
        this.text = text;
        this.createDate = createDate;
    }

    public Review(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Dish getDish() {
        return dish;
    }

    public UserAccount getUser() {
        return user;
    }

    public Review getParent() {
        return parent;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    //    public static Builder builder(){
//        return new Builder();
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && dish == review.dish && user == review.user && parent == review.parent && Objects.equals(text, review.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dish, user, parent, text);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", dishId=" + dish +
                ", userId=" + user +
                ", parentId=" + parent +
                ", text='" + text + '\'' +
                '}';
    }

//    public static class Builder{
//        private long id;
//        private int dishId;
//        private long userId;
//        private long parentId;
//        private String text;
//
//        private Builder(){}
//
//        public Builder withId(long id){
//            this.id = id;
//            return this;
//        }
//
//        public Builder withDishId(int dishId){
//            this.dishId = dishId;
//            return this;
//        }
//
//        public Builder withUserId(long userId){
//            this.userId = userId;
//            return this;
//        }
//
//        public Builder withParentId(long parentId){
//            this.parentId = parentId;
//            return this;
//        }
//
//        public Builder withText(String text){
//            this.text = text;
//            return this;
//        }
//
//        public Review build(){
//            return new Review(this.id, this.dishId, this.userId, this.parentId, this.text);
//        }
//    }
}
