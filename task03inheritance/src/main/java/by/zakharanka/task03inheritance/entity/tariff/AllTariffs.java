package by.zakharanka.task03inheritance.entity.tariff;


import java.util.Objects;

/**
 * class, the fields of which contain data on tariffs
 */
public class AllTariffs {
    private final ListTariff<LimitTariff> limitTariff;
    private final ListTariff<FullUnlimitedTariff> fullUnlimitedTariff;
    private final ListTariff<ChildTariff> childTariff;
    private final ListTariff<PensionTariff> pensionTariff;
    private final ListTariff<UnlimitedInternetTariff> unlimitedInternetTariff;
    private final ListTariff<UnlimitedMinTariff> unlimitedMinTariff;

    public AllTariffs(ListTariff<LimitTariff> limitTariff, ListTariff<FullUnlimitedTariff> fullUnlimitedTariff, ListTariff<ChildTariff> childTariff, ListTariff<PensionTariff> pensionTariff, ListTariff<UnlimitedInternetTariff> unlimitedInternetTariff, ListTariff<UnlimitedMinTariff> unlimitedMinTariff) {
        this.limitTariff = limitTariff;
        this.fullUnlimitedTariff = fullUnlimitedTariff;
        this.childTariff = childTariff;
        this.pensionTariff = pensionTariff;
        this.unlimitedInternetTariff = unlimitedInternetTariff;
        this.unlimitedMinTariff = unlimitedMinTariff;
    }



    public LimitTariff[] getArrLimitTariff(){
        return limitTariff.list.toArray(new LimitTariff[0]);
    }

    public FullUnlimitedTariff[] getArrFullUnlimitedTariff(){
        return fullUnlimitedTariff.list.toArray(new FullUnlimitedTariff[0]);
    }

    public ChildTariff[] getArrChildTariff(){
        return childTariff.list.toArray(new ChildTariff[0]);
    }

    public PensionTariff[] getArrPensionTariff(){
        return pensionTariff.list.toArray(new PensionTariff[0]);
    }

    public UnlimitedInternetTariff[] getArrUnlimitedInternetTariff(){
        return unlimitedInternetTariff.list.toArray(new UnlimitedInternetTariff[0]);
    }

    public UnlimitedMinTariff[] getArrUnlimitedMinTariff(){
        return unlimitedMinTariff.list.toArray(new UnlimitedMinTariff[0]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllTariffs that = (AllTariffs) o;
        return limitTariff.equals(that.limitTariff) && fullUnlimitedTariff.equals(that.fullUnlimitedTariff) && childTariff.equals(that.childTariff) && pensionTariff.equals(that.pensionTariff) && unlimitedInternetTariff.equals(that.unlimitedInternetTariff) && unlimitedMinTariff.equals(that.unlimitedMinTariff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(limitTariff, fullUnlimitedTariff, childTariff, pensionTariff, unlimitedInternetTariff, unlimitedMinTariff);
    }

    @Override
    public String toString() {
        return "AllTariffs{" +
                "limitTariff=" + limitTariff.toString() +
                ", fullUnlimitedTariff=" + fullUnlimitedTariff.toString() +
                '}';
    }
}
