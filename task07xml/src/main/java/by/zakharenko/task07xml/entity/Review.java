package by.zakharenko.task07xml.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Review {
    private final long id;
    private final Dish dish;
    private final UserAccount user;
    private final Review parent;
    private final String text;
    private final LocalDateTime dateTime;

    private Review(long id, Dish dish, UserAccount user,
                   Review parent, String text, LocalDateTime dateTime) {
        this.id = id;
        this.dish = dish;
        this.user = user;
        this.parent = parent;
        this.text = text;
        this.dateTime = dateTime;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public static Builder builder(){
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && Objects.equals(dish, review.dish) && Objects.equals(user, review.user) && Objects.equals(parent, review.parent) && Objects.equals(text, review.text) && Objects.equals(dateTime, review.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dish, user, parent, text, dateTime);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", dish=" + dish +
                ", user=" + user +
                ", parent=" + parent +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    public static class Builder{
        private long id;
        private Dish dish;
        private UserAccount user;
        private Review parent;
        private String text;
        private LocalDateTime dateTime;

        private Builder(){}

        public Builder withId(long id){
            this.id = id;
            return this;
        }

        public Builder withDish(Dish dish){
            this.dish = dish;
            return this;
        }

        public Builder withUser(UserAccount user){
            this.user = user;
            return this;
        }

        public Builder withParent(Review parent){
            this.parent = parent;
            return this;
        }

        public Builder withText(String text){
            this.text = text;
            return this;
        }

        public Builder withDateTime(LocalDateTime dateTime){
            this.dateTime = dateTime;
            return this;
        }

        public Review build(){
            return new Review(this.id, this.dish, this.user, this.parent, this.text, this.dateTime);
        }
    }
}
