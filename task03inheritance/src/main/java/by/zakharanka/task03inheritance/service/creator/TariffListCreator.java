package by.zakharanka.task03inheritance.service.creator;

import by.zakharanka.task03inheritance.dal.JSONDal;
import by.zakharanka.task03inheritance.dal.exception.DalException;
import by.zakharanka.task03inheritance.dal.factory.DalFactory;
import by.zakharanka.task03inheritance.dal.util.FileResourcesUtils;
import by.zakharanka.task03inheritance.entity.tariff.AllTariffs;
import by.zakharanka.task03inheritance.entity.tariff.ListTariff;
import by.zakharanka.task03inheritance.entity.tariff.Tariff;
import by.zakharanka.task03inheritance.service.exception.ServiceException;

import java.io.File;

public class TariffListCreator implements Creator<ListTariff<Tariff>>{
    private static final String PATH = "data/RandomParametersTariff.json";

    @Override
    public ListTariff<Tariff> createFromFile() throws ServiceException {
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        try{
            DalFactory dalFactory = DalFactory.getInstance();
            JSONDal jsonDal = dalFactory.getJSONFileDal();
            File file = fileResourcesUtils.getFileFromResource(PATH);
            AllTariffs allTariffs = jsonDal.readTariffsFromJSON(file.getPath());
            return allTariffsToListTariff(allTariffs);
        } catch (DalException e){
            throw new ServiceException("Error creator");
        }
    }

    private ListTariff<Tariff> allTariffsToListTariff(AllTariffs allTariffs){
        ListTariff<Tariff> listTariff = new ListTariff<>();
        listTariff.addListTariff(allTariffs.getArrLimitTariff());
        listTariff.addListTariff(allTariffs.getArrFullUnlimitedTariff());
        listTariff.addListTariff(allTariffs.getArrChildTariff());
        listTariff.addListTariff(allTariffs.getArrPensionTariff());
        listTariff.addListTariff(allTariffs.getArrUnlimitedInternetTariff());
        listTariff.addListTariff(allTariffs.getArrUnlimitedMinTariff());
        return listTariff;
    }
}
