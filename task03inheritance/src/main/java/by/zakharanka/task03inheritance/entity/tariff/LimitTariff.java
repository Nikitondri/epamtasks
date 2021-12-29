package by.zakharanka.task03inheritance.entity.tariff;

import by.zakharanka.task03inheritance.entity.Client;

import java.util.List;

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
