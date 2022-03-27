package by.zakharenko.cafe.entity;

import by.zakharenko.cafe.entity.enumeration.OrderStatus;
import by.zakharenko.cafe.entity.enumeration.PaymentType;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class Order extends CafeEntity {
    private final long id;
    private UserAccount user;
    private OrderStatus orderStatus;
    private Double cost;
    private PaymentType paymentType;
    private LocalDateTime createDate;
    private LocalDateTime desiredTime;
    private LocalDateTime finishedTime;
    private Double bonusesUsed;
    private int rating;
    private UserAccount worker;
    private Map<Dish, Integer> dishes;

    public Order(long id, UserAccount user, OrderStatus orderStatus, Double cost,
                 PaymentType paymentType, LocalDateTime createDate, LocalDateTime desiredTime,
                 LocalDateTime finishedTime, Double bonusesUsed, int rating, UserAccount worker,
                 Map<Dish, Integer> dishes) {
        this.id = id;
        this.user = user;
        this.orderStatus = orderStatus;
        this.cost = cost;
        this.paymentType = paymentType;
        this.createDate = createDate;
        this.desiredTime = desiredTime;
        this.finishedTime = finishedTime;
        this.bonusesUsed = bonusesUsed;
        this.rating = rating;
        this.worker = worker;
        this.dishes = dishes;
    }

    public Order(long id, UserAccount user, OrderStatus orderStatus, Double cost,
                 PaymentType paymentType, LocalDateTime createDate, LocalDateTime desiredTime,
                 LocalDateTime finishedTime, Double bonusesUsed, int rating, UserAccount worker) {
        this.id = id;
        this.user = user;
        this.orderStatus = orderStatus;
        this.cost = cost;
        this.paymentType = paymentType;
        this.createDate = createDate;
        this.desiredTime = desiredTime;
        this.finishedTime = finishedTime;
        this.bonusesUsed = bonusesUsed;
        this.rating = rating;
        this.worker = worker;
    }

    public Order(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public UserAccount getUser() {
        return user;
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

    public UserAccount getWorker() {
        return worker;
    }

    public Map<Dish, Integer> getDishes() {
        return dishes;
    }

//    public static Builder builder(){
//        return new Builder();
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && user == order.user && rating == order.rating && worker == order.worker && orderStatus == order.orderStatus && Objects.equals(cost, order.cost) && paymentType == order.paymentType && Objects.equals(createDate, order.createDate) && Objects.equals(desiredTime, order.desiredTime) && Objects.equals(finishedTime, order.finishedTime) && Objects.equals(bonusesUsed, order.bonusesUsed) && Objects.equals(dishes, order.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, orderStatus, cost, paymentType, createDate, desiredTime, finishedTime, bonusesUsed, rating, worker, dishes);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userID=" + user +
                ", orderStatus=" + orderStatus +
                ", cost=" + cost +
                ", paymentType=" + paymentType +
                ", createDate=" + createDate +
                ", desiredTime=" + desiredTime +
                ", finishedTime=" + finishedTime +
                ", bonusesUsed=" + bonusesUsed +
                ", rating=" + rating +
                ", workerId=" + worker +
                ", dishes=" + dishes +
                '}';
    }

//    public static class Builder{
//        private long id;
//        private long userID;
//        private OrderStatus orderStatus;
//        private Double cost;
//        private PaymentType paymentType;
//        private LocalDateTime createDate;
//        private LocalDateTime desiredTime;
//        private LocalDateTime finishedTime;
//        private Double bonusesUsed;
//        private int rating;
//        private long workerId;
//        private Map<Dish, Integer> dishes;
//
//        private Builder(){}
//
//        public Builder withId(long id){
//            this.id = id;
//            return this;
//        }
//
//        public Builder withUserId(long userId){
//            this.userID = userId;
//            return this;
//        }
//
//        public Builder withWorkerId(long workerId){
//            this.workerId = workerId;
//            return this;
//        }
//
//        public Builder withStatus(OrderStatus status){
//            this.orderStatus = status;
//            return this;
//        }
//
//        public Builder withCost(double cost){
//            this.cost = cost;
//            return this;
//        }
//
//        public Builder withPaymentType(PaymentType paymentType){
//            this.paymentType = paymentType;
//            return this;
//        }
//
//        public Builder withCreateDate(LocalDateTime createDate){
//            this.createDate = createDate;
//            return this;
//        }
//
//        public Builder withDesiredTime(LocalDateTime desiredTime){
//            this.desiredTime = desiredTime;
//            return this;
//        }
//
//        public Builder withFinishedTime(LocalDateTime finishedTime){
//            this.finishedTime = finishedTime;
//            return this;
//        }
//
//        public Builder withBonusesUsed(double bonusesUsed){
//            this.bonusesUsed = bonusesUsed;
//            return this;
//        }
//
//        public Builder withRating(int rating){
//            this.rating = rating;
//            return this;
//        }
//
//        public Builder withDishes(Map<Dish, Integer> dishes){
//            this.dishes = dishes;
//            return this;
//        }
//
//        public Order build(){
//            return new Order(
//                    this.id,
//                    this.userID,
//                    this.orderStatus,
//                    this.cost,
//                    this.paymentType,
//                    this.createDate,
//                    this.desiredTime,
//                    this.finishedTime,
//                    this.bonusesUsed,
//                    this.rating,
//                    this.workerId,
//                    this.dishes
//            );
//        }
//
//    }
}
