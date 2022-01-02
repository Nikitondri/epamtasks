package by.zakharanka.task03inheritance.entity.tariff;

import by.zakharanka.task03inheritance.entity.Client;

import java.util.List;
import java.util.Objects;

public class FullUnlimitedTariff extends Tariff{
    int roamingMinCount;

    public FullUnlimitedTariff(String tariffName, List<Client> listClient, int monthlyCost, int roamingMinCount) {
        super(tariffName, listClient, monthlyCost);
        this.roamingMinCount = roamingMinCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullUnlimitedTariff that = (FullUnlimitedTariff) o;
        return roamingMinCount == that.roamingMinCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roamingMinCount);
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
