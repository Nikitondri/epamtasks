package by.zakharanka.task03inheritance.entity.tariff;

import by.zakharanka.task03inheritance.entity.Client;

import java.util.List;
import java.util.Objects;

public class UnlimitedMinTariff extends Tariff{
    int gbCount;
    int smsCount;
    int extraGBPrice;
    int extraSMSPrice;

    public UnlimitedMinTariff(String tariffName, List<Client> listClient, int monthlyCost, int gbCount, int smsCount, int extraGBPrice, int extraSMSPrice) {
        super(tariffName, listClient, monthlyCost);
        this.gbCount = gbCount;
        this.smsCount = smsCount;
        this.extraGBPrice = extraGBPrice;
        this.extraSMSPrice = extraSMSPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UnlimitedMinTariff that = (UnlimitedMinTariff) o;
        return gbCount == that.gbCount && smsCount == that.smsCount && extraGBPrice == that.extraGBPrice && extraSMSPrice == that.extraSMSPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gbCount, smsCount, extraGBPrice, extraSMSPrice);
    }

    @Override
    public String toString() {
        return "UnlimitedMinTariff{" +
                "tariffName='" + tariffName + '\'' +
                ", monthlyCost=" + monthlyCost +
                ", listClient=" + listClient +
                ", gbCount=" + gbCount +
                ", smsCount=" + smsCount +
                ", extraGBPrice=" + extraGBPrice +
                ", extraSMSPrice=" + extraSMSPrice +
                '}';
    }
}
