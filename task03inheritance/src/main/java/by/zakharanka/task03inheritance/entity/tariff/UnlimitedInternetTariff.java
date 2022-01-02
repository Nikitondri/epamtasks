package by.zakharanka.task03inheritance.entity.tariff;

import by.zakharanka.task03inheritance.entity.Client;

import java.util.List;
import java.util.Objects;

public class UnlimitedInternetTariff extends Tariff{
    int minCount;
    int smsCount;
    int extraMinPrice;
    int extraSMSPrice;

    public UnlimitedInternetTariff(String tariffName, List<Client> listClient, int monthlyCost, int minCount, int smsCount, int extraMinPrice, int extraSMSPrice) {
        super(tariffName, listClient, monthlyCost);
        this.minCount = minCount;
        this.smsCount = smsCount;
        this.extraMinPrice = extraMinPrice;
        this.extraSMSPrice = extraSMSPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UnlimitedInternetTariff that = (UnlimitedInternetTariff) o;
        return minCount == that.minCount && smsCount == that.smsCount && extraMinPrice == that.extraMinPrice && extraSMSPrice == that.extraSMSPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), minCount, smsCount, extraMinPrice, extraSMSPrice);
    }

    @Override
    public String toString() {
        return "UnlimitedInternetTariff{" +
                "tariffName='" + tariffName + '\'' +
                ", monthlyCost=" + monthlyCost +
                ", listClient=" + listClient +
                ", minCount=" + minCount +
                ", smsCount=" + smsCount +
                ", extraMinPrice=" + extraMinPrice +
                ", extraSMSPrice=" + extraSMSPrice +
                '}';
    }
}
