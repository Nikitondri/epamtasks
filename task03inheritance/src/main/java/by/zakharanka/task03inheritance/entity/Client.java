package by.zakharanka.task03inheritance.entity;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return phoneNumber == client.phoneNumber && Objects.equals(name, client.name) && Objects.equals(tariff, client.tariff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, tariff);
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
