package by.zakharanka.task03inheritance.entity.tariff;

import by.zakharanka.task03inheritance.entity.Client;

import java.util.List;

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
