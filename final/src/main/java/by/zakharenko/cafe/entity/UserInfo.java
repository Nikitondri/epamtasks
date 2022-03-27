package by.zakharenko.cafe.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserInfo extends CafeEntity {
    private final long id;
    private String surname;
    private String name;
    private String phone;
    private String email;
    private LocalDateTime createDate;
    private double balance;
    private double bonus;

    public UserInfo(long id, String surname, String name,
                    String phone, String email, LocalDateTime createDate, double balance,
                    double bonus) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.createDate = createDate;
        this.balance = balance;
        this.bonus = bonus;
    }

    public UserInfo(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }


    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public double getBalance() {
        return balance;
    }

    public double getBonus() {
        return bonus;
    }

//    public static Builder builder() {
//        return new Builder();
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return id == userInfo.id && Double.compare(userInfo.balance, balance) == 0 && Double.compare(userInfo.bonus, bonus) == 0 && surname.equals(userInfo.surname) && name.equals(userInfo.name) && phone.equals(userInfo.phone) && email.equals(userInfo.email) && createDate.equals(userInfo.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, phone, email, createDate, balance, bonus);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                ", balance=" + balance +
                ", bonus=" + bonus +
                '}';
    }

//    public static class Builder{
//        private long id;
//        private String surname;
//        private String name;
//        private String phone;
//        private String email;
//        private LocalDateTime createDate;
//        private double balance;
//        private double bonus;
//
//        private Builder(){}
//
//        public Builder withId(long id){
//            this.id = id;
//            return this;
//        }
//
//        public Builder withSurname(String surname) {
//            this.surname = surname;
//            return this;
//        }
//
//        public Builder withName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Builder withPhone(String phone) {
//            this.phone = phone;
//            return this;
//        }
//
//        public Builder withEmail(String email) {
//            this.email = email;
//            return this;
//        }
//
//        public Builder withCreateDate(LocalDateTime createDate) {
//            this.createDate = createDate;
//            return this;
//        }
//
//        public Builder withBalance(double balance) {
//            this.balance = balance;
//            return this;
//        }
//
//        public Builder withBonus(double bonus) {
//            this.bonus = bonus;
//            return this;
//        }
//
//        public UserInfo build(){
//            return new UserInfo(
//                    this.id,
//                    this.surname,
//                    this.name,
//                    this.phone,
//                    this.email,
//                    this.createDate,
//                    this.balance,
//                    this.bonus
//            );
//        }
//    }
}
