package by.zakharanka.task03inheritance.entity.tariff;

import by.zakharanka.task03inheritance.entity.Client;

import java.util.List;

public class FullUnlimitedTariff extends Tariff{
    int roamingMinCount;

    public FullUnlimitedTariff(String tariffName, List<Client> listClient, int monthlyCost, int roamingMinCount) {
        super(tariffName, listClient, monthlyCost);
        this.roamingMinCount = roamingMinCount;
    }

    @Override
    public String toString() {
        return "FullUnlimitedTariff{" +
                "tariffName='" + tariffName + '\'' +
                ", monthlyCost=" + monthlyCost +
                ", roamingMinCount=" + roamingMinCount +
                ", listClient=" + listClient +
                '}';
    }
}
