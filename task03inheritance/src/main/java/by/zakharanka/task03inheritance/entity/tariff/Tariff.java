package by.zakharanka.task03inheritance.entity.tariff;

import by.zakharanka.task03inheritance.entity.Client;

import java.util.List;

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
    public String toString() {
        return "Tariff{" +
                "tariffName='" + tariffName + '\'' +
                ", listClient=" + listClient +
                ", monthlyCost=" + monthlyCost +
                '}';
    }
}
