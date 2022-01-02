package by.zakharanka.task03inheritance.entity.tariff;

import by.zakharanka.task03inheritance.entity.Client;

import java.util.List;
import java.util.Objects;

public class ChildTariff extends LimitTariff{
    Client mother;
    Client dad;

    public ChildTariff(String tariffName, List<Client> listClient, int monthlyCost, int minCount, int gbCount, int smsCount, int extraMinPrice, int extraGBPrice, int extraSMSPrice, Client mother, Client dad) {
        super(tariffName, listClient, monthlyCost, minCount, gbCount, smsCount, extraMinPrice, extraGBPrice, extraSMSPrice);
        this.mother = mother;
        this.dad = dad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildTariff that = (ChildTariff) o;
        return mother.equals(that.mother) && dad.equals(that.dad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, dad);
    }

    @Override
    public String toString() {
        return "ChildTariff{" +
                "tariffName='" + tariffName + '\'' +
                ", monthlyCost=" + monthlyCost +
                ", mother=" + mother +
                ", dad=" + dad +
                ", minCount=" + minCount +
                ", gbCount=" + gbCount +
                ", smsCount=" + smsCount +
                ", extraMinPrice=" + extraMinPrice +
                ", extraGBPrice=" + extraGBPrice +
                ", extraSMSPrice=" + extraSMSPrice +
                ", listClient=" + listClient +
                '}';
    }
}
