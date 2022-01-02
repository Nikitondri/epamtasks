package by.zakharanka.task03inheritance.entity.tariff;

import by.zakharanka.task03inheritance.entity.Client;

import java.util.List;
import java.util.Objects;

public abstract class Tariff {
    String tariffName;
    List<Client> listClient;
    int monthlyCost;

    Tariff(String tariffName, List<Client> listClient, int monthlyCost) {
        this.tariffName = tariffName;
        this.listClient = listClient;
        this.monthlyCost = monthlyCost;
    }

    public int countClients(){
        return listClient.size();
    }

    public int getMonthlyCost() {
        return monthlyCost;
    }

    public String getTariffName() {
        return tariffName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return monthlyCost == tariff.monthlyCost && Objects.equals(tariffName, tariff.tariffName) && Objects.equals(listClient, tariff.listClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tariffName, listClient, monthlyCost);
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "tariffName='" + tariffName + '\'' +
                ", listClient=" + listClient +
                ", monthlyCost=" + monthlyCost +
                '}';
    }
}
