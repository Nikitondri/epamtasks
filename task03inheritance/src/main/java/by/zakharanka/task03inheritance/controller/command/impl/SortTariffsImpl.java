package by.zakharanka.task03inheritance.controller.command.impl;

import by.zakharanka.task03inheritance.controller.command.Command;
import by.zakharanka.task03inheritance.controller.exception.ControllerException;
import by.zakharanka.task03inheritance.entity.tariff.ListTariff;
import by.zakharanka.task03inheritance.entity.tariff.Tariff;
import by.zakharanka.task03inheritance.service.TariffService;
import by.zakharanka.task03inheritance.service.creator.Creator;
import by.zakharanka.task03inheritance.service.creator.TariffListCreator;
import by.zakharanka.task03inheritance.service.exception.ServiceException;
import by.zakharanka.task03inheritance.service.factory.ServiceFactory;

import java.util.HashMap;

public class SortTariffsImpl implements Command {
    @Override
    public HashMap<String, Exception> execute(String request) throws ControllerException {
        HashMap<String, Exception> res = new HashMap<>();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TariffService tariffService = serviceFactory.getTariffService();
        Creator<ListTariff<Tariff>> creator = new TariffListCreator();
        try{
            res.put(tariffService.sortTariffs(creator.createFromFile()), null);
        } catch (ServiceException e){
            throw new ControllerException(e);
        }
        return res;
    }
}
