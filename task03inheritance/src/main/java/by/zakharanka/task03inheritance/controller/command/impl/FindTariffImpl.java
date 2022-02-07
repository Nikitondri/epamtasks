package by.zakharanka.task03inheritance.controller.command.impl;

import by.zakharanka.task03inheritance.controller.command.Command;
import by.zakharanka.task03inheritance.controller.exception.ControllerException;
import by.zakharanka.task03inheritance.entity.ParametersList;
import by.zakharanka.task03inheritance.entity.tariff.ListTariff;
import by.zakharanka.task03inheritance.entity.tariff.Tariff;
import by.zakharanka.task03inheritance.service.TariffService;
import by.zakharanka.task03inheritance.service.creator.Creator;
import by.zakharanka.task03inheritance.service.creator.ParametersListCreator;
import by.zakharanka.task03inheritance.service.creator.TariffListCreator;
import by.zakharanka.task03inheritance.service.exception.ServiceException;
import by.zakharanka.task03inheritance.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class FindTariffImpl implements Command {
    private static final String PATH_PARAMETERS = "data/parametersTariff.json";
    private static final String PATH = "data/RandomParametersTariff.json";

    static final Logger LOGGER = LogManager.getLogger(FindTariffImpl.class.getName());

    /**
     * Method for calling methods to search for a tariff by specified parameters from the list of parameters
     * and exception handling
     * @see Command
     * @see TariffService
     * @see Creator
     * @param request user-selected command
     * @return {@code HashMap} object including tariff search result or exception
     * @throws ControllerException handled on method {@code execute} invocation
     */
    @Override
    public Map<Boolean, String> execute(String request) throws ControllerException {
        Map<Boolean, String> res = new HashMap<>();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TariffService tariffService = serviceFactory.getTariffService();
        Creator<ListTariff<Tariff>> creatorListTariff = new TariffListCreator();
        Creator<ParametersList> creatorListParameters = new ParametersListCreator();
        try{
            LOGGER.trace("FindTariffImpl completed correctly");
            res.put(true, tariffService.findTariff(creatorListTariff.createFromFile(PATH), creatorListParameters.createFromFile(PATH_PARAMETERS)));
        } catch (ServiceException e){
            throw new ControllerException(e);
        }
        return res;
    }
}
