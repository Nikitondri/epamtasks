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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class SortTariffsImpl implements Command {
    private static final String PATH = "data/RandomParametersTariff.json";

    static final Logger LOGGER = LogManager.getLogger(SortTariffsImpl.class.getName());

    /**
     * Method for calling methods to sort tariffs in ascending monthly order
     * and exception handling
     * @see Command
     * @see TariffService
     * @see Creator
     * @param request user-selected command
     * @return {@code HashMap} object including sort tariffs result or exception
     * @throws ControllerException handled on method {@code execute} invocation
     */
    @Override
    public Map<Boolean, String> execute(String request) throws ControllerException {
        Map<Boolean, String> res = new HashMap<>();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TariffService tariffService = serviceFactory.getTariffService();
        Creator<ListTariff<Tariff>> creator = new TariffListCreator();
        try{
            LOGGER.trace("SortTariffsImpl completed correctly");
            res.put(true, tariffService.sortTariffs(creator.createFromFile(PATH)));
        } catch (ServiceException e){
            throw new ControllerException(e);
        }
        return res;
    }
}
