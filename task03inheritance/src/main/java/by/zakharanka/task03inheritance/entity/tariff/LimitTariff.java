package by.zakharanka.task03inheritance.entity.tariff;

import by.zakharanka.task03inheritance.entity.Client;

import java.util.List;
import java.util.Objects;

public class LimitTariff extends Tariff {
    int minCount;
    int gbCount;
    int smsCount;
    int extraMinPrice;
    int extraGBPrice;
    int extraSMSPrice;

    public LimitTariff(String tariffName, List<Client> listClient, int monthlyCost, int minCount, int gbCount, int smsCount, int extraMinPrice, int extraGBPrice, int extraSMSPrice) {
        super(tariffName, listClient, monthlyCost);
        this.minCount = minCount;
        this.gbCount = gbCount;
        this.smsCount = smsCount;
        this.extraMinPrice = extraMinPrice;
        this.extraGBPrice = extraGBPrice;
        this.extraSMSPrice = extraSMSPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LimitTariff that = (LimitTariff) o;
        return minCount == that.minCount && gbCount == that.gbCount && smsCount == that.smsCount && extraMinPrice == that.extraMinPrice && extraGBPrice == that.extraGBPrice && extraSMSPrice == that.extraSMSPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minCount, gbCount, smsCount, extraMinPrice, extraGBPrice, extraSMSPrice);
    }

    @Override
    public String toString() {
        return "LimitTariff{" +
                "tariffName='" + tariffName + '\'' +
                ", monthlyCost=" + monthlyCost +
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
