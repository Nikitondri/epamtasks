package by.zakharanka.task03inheritance.service.impl;

import by.zakharanka.task03inheritance.entity.ParametersList;
import by.zakharanka.task03inheritance.entity.tariff.ListTariff;
import by.zakharanka.task03inheritance.entity.tariff.Tariff;
import by.zakharanka.task03inheritance.service.TariffService;
import by.zakharanka.task03inheritance.service.exception.ServiceException;


public class TariffServiceImpl implements TariffService {
    /**
     * counts the total number of customers from the list of tariffs
     * @param listTariff list with tariff data
     * @return total number of clients
     */
    @Override
    public String totalNumberClients(ListTariff<Tariff> listTariff) throws ServiceException {
        int total = 0;
        for(int i = 0; i < listTariff.size(); i++){
            try {
                total += listTariff.getTariff(i).countClients();
            } catch (Exception e){
                throw new ServiceException("Error service");
            }
        }
        return Integer.toString(total);
    }

    /**
     * sorts tariffs in ascending monthly order using simple insert sorting
     * @param listTariff list with tariff data
     * @return sorted list
     */
    @Override
    public String sortTariffs(ListTariff<Tariff> listTariff) {
        for(int i = 0; i < listTariff.size(); i++){
            for(int j = i; j > 0 && listTariff.getTariff(j - 1).getMonthlyCost() > listTariff.getTariff(j).getMonthlyCost(); j--){
                listTariff.swapTariffs(j, j - 1);
            }
        }
        return listTariff.toString();
    }

    /**
     * finds from the list of tariffs the tariff corresponding to the parameters from the list of parameters
     * @param listTariff list with tariff data
     * @return desired tariff
     */
    @Override
    public String findTariff(ListTariff<Tariff> listTariff, ParametersList parameters) throws ServiceException {
        ListTariff<Tariff> resultList = new ListTariff<>();
        for(int i = 0; i < listTariff.size(); i++){
            try {
                if (listTariff.getTariff(i).getTariffName().equals(parameters.getElement(0)) &&
                        Integer.toString(listTariff.getTariff(i).getMonthlyCost()).equals(parameters.getElement(1))) {
                    resultList.addTariff(listTariff.getTariff(i));
                }
            } catch (Exception e) {
                throw new ServiceException("Service exception");
            }
        }
        return resultList.toString();
    }

}
