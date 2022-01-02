package by.zakharanka.task03inheritance.entity.tariff;

import by.zakharanka.task03inheritance.entity.Client;

import java.util.List;
import java.util.Objects;

public class PensionTariff extends LimitTariff{
    List<Client> selectedClients;

    public PensionTariff(String tariffName, List<Client> listClient, int monthlyCost, int minCount, int gbCount, int smsCount, int extraMinPrice, int extraGBPrice, int extraSMSPrice, List<Client> selectedClients) {
        super(tariffName, listClient, monthlyCost, minCount, gbCount, smsCount, extraMinPrice, extraGBPrice, extraSMSPrice);
        this.selectedClients = selectedClients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PensionTariff that = (PensionTariff) o;
        return selectedClients.equals(that.selectedClients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), selectedClients);
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
