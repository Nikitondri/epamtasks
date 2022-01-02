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

    /**
     * initializes an ListTariff object with data from a file
     * @see ListTariff
     * @param path the path to the file
     * @return ListTariff object with initialized fields
     * @throws ServiceException to handle exceptions
     */
    @Override
    public ListTariff<Tariff> createFromFile(String path) throws ServiceException {
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        try{
            DalFactory dalFactory = DalFactory.getInstance();
            JSONDal jsonDal = dalFactory.getJSONFileDal();
            File file = fileResourcesUtils.getFileFromResource(path);
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
