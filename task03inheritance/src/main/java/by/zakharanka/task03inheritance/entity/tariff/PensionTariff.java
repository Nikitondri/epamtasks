package by.zakharanka.task03inheritance.entity.tariff;

import by.zakharanka.task03inheritance.entity.Client;

import java.util.List;

public class PensionTariff extends LimitTariff{
    List<Client> selectedClients;

    public PensionTariff(String tariffName, List<Client> listClient, int monthlyCost, int minCount, int gbCount, int smsCount, int extraMinPrice, int extraGBPrice, int extraSMSPrice, List<Client> selectedClients) {
        super(tariffName, listClient, monthlyCost, minCount, gbCount, smsCount, extraMinPrice, extraGBPrice, extraSMSPrice);
        this.selectedClients = selectedClients;
    }

    @Override
    public String toString() {
        return "PensionTariff{" +
                "tariffName='" + tariffName + '\'' +
                ", monthlyCost=" + monthlyCost +
                ", minCount=" + minCount +
                ", gbCount=" + gbCount +
                ", smsCount=" + smsCount +
                ", extraMinPrice=" + extraMinPrice +
                ", extraGBPrice=" + extraGBPrice +
                ", extraSMSPrice=" + extraSMSPrice +
                ", selectedClients=" + selectedClients +
                ", listClient=" + listClient +
                '}';
    }
}
