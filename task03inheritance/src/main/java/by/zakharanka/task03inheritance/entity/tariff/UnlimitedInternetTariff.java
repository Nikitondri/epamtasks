package by.zakharanka.task03inheritance.entity.tariff;

import by.zakharanka.task03inheritance.entity.Client;

import java.util.List;

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
