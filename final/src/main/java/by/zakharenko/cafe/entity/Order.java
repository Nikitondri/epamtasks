package by.zakharenko.cafe.entity;

import by.zakharenko.cafe.entity.enumeration.OrderStatus;
import by.zakharenko.cafe.entity.enumeration.PaymentType;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class Order extends CafeEntity {
    private final long id;
    private final long userID;
    private final OrderStatus orderStatus;
    private final Double cost;
    private final PaymentType paymentType;
    private final LocalDateTime createDate;
    private final LocalDateTime desiredTime;
    private final LocalDateTime finishedTime;
    private final Double bonusesUsed;
    private final int rating;
    private final long workerId;
    private final Map<Dish, Integer> dishes;

    private Order(long id, long userID, OrderStatus orderStatus, Double cost,
                  PaymentType paymentType, LocalDateTime createDate, LocalDateTime desiredTime,
                  LocalDateTime finishedTime, Double bonusesUsed, int rating, long workerId,
                  Map<Dish, Integer> dishes) {
        this.id = id;
        this.userID = userID;
        this.orderStatus = orderStatus;
        this.cost = cost;
        this.paymentType = paymentType;
        this.createDate = createDate;
        this.desiredTime = desiredTime;
        this.finishedTime = finishedTime;
        this.bonusesUsed = bonusesUsed;
        this.rating = rating;
        this.workerId = workerId;
        this.dishes = dishes;
    }

    public long getId() {
        return id;
    }

    public long getUserID() {
        return userID;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Double getCost() {
        return cost;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getDesiredTime() {
        return desiredTime;
    }

    public LocalDateTime getFinishedTime() {
        return finishedTime;
    }

    public Double getBonusesUsed() {
        return bonusesUsed;
    }

    public int getRating() {
        return rating;
    }

    public long getWorkerId() {
        return workerId;
    }

    public Map<Dish, Integer> getDishes() {
        return dishes;
    }

    public static Builder builder(){
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && userID == order.userID && rating == order.rating && workerId == order.workerId && orderStatus == order.orderStatus && Objects.equals(cost, order.cost) && paymentType == order.paymentType && Objects.equals(createDate, order.createDate) && Objects.equals(desiredTime, order.desiredTime) && Objects.equals(finishedTime, order.finishedTime) && Objects.equals(bonusesUsed, order.bonusesUsed) && Objects.equals(dishes, order.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userID, orderStatus, cost, paymentType, createDate, desiredTime, finishedTime, bonusesUsed, rating, workerId, dishes);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userID=" + userID +
                ", orderStatus=" + orderStatus +
                ", cost=" + cost +
                ", paymentType=" + paymentType +
                ", createDate=" + createDate +
                ", desiredTime=" + desiredTime +
                ", finishedTime=" + finishedTime +
                ", bonusesUsed=" + bonusesUsed +
                ", rating=" + rating +
                ", workerId=" + workerId +
                ", dishes=" + dishes +
                '}';
    }

    public static class Builder{
        private long id;
        private long userID;
        private OrderStatus orderStatus;
        private Double cost;
        private PaymentType paymentType;
        private LocalDateTime createDate;
        private LocalDateTime desiredTime;
        private LocalDateTime finishedTime;
        private Double bonusesUsed;
        private int rating;
        private long workerId;
        private Map<Dish, Integer> dishes;

        private Builder(){}

        public Builder withId(long id){
            this.id = id;
            return this;
        }

        public Builder withUserId(long userId){
            this.userID = userId;
            return this;
        }

        public Builder withWorkerId(long workerId){
            this.workerId = workerId;
            return this;
        }

        public Builder withStatus(OrderStatus status){
            this.orderStatus = status;
            return this;
        }

        public Builder withCost(double cost){
            this.cost = cost;
            return this;
        }

        public Builder withPaymentType(PaymentType paymentType){
            this.paymentType = paymentType;
            return this;
        }

        public Builder withCreateDate(LocalDateTime createDate){
            this.createDate = createDate;
            return this;
        }

        public Builder withDesiredTime(LocalDateTime desiredTime){
            this.desiredTime = desiredTime;
            return this;
        }

        public Builder withFinishedTime(LocalDateTime finishedTime){
            this.finishedTime = finishedTime;
            return this;
        }

        public Builder withBonusesUsed(double bonusesUsed){
            this.bonusesUsed = bonusesUsed;
            return this;
        }

        public Builder withRating(int rating){
            this.rating = rating;
            return this;
        }

        public Builder withDishes(Map<Dish, Integer> dishes){
            this.dishes = dishes;
            return this;
        }

        public Order build(){
            return new Order(
                    this.id,
                    this.userID,
                    this.orderStatus,
                    this.cost,
                    this.paymentType,
                    this.createDate,
                    this.desiredTime,
                    this.finishedTime,
                    this.bonusesUsed,
                    this.rating,
                    this.workerId,
                    this.dishes
            );
        }

    }
}
