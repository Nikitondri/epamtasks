package by.zakharanka.task03inheritance.service;

import by.zakharanka.task03inheritance.entity.ParametersList;
import by.zakharanka.task03inheritance.entity.tariff.ListTariff;
import by.zakharanka.task03inheritance.entity.tariff.Tariff;
import by.zakharanka.task03inheritance.service.exception.ServiceException;

public interface TariffService {
    String totalNumberClients(ListTariff<Tariff> listTariff) throws ServiceException;
    String sortTariffs(ListTariff<Tariff> listTariff) throws ServiceException;
    String findTariff(ListTariff<Tariff> listTariff, ParametersList parameters) throws ServiceException;
}
