package by.zakharanka.task03inheritance.entity;

public class Client {
    String name;
    long phoneNumber;
    String tariff;

    public Client(String name, long phoneNumber, String tariff) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.tariff = tariff;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", tariff='" + tariff + '\'' +
                '}';
    }
}
