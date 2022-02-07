package by.zakharanka.task03inheritance.controller.command.impl;

import by.zakharanka.task03inheritance.controller.command.Command;
import by.zakharanka.task03inheritance.controller.exception.ControllerException;
import by.zakharanka.task03inheritance.service.TariffService;
import by.zakharanka.task03inheritance.service.creator.Creator;
import by.zakharanka.task03inheritance.service.exception.ServiceException;
import by.zakharanka.task03inheritance.service.generator.Generator;
import by.zakharanka.task03inheritance.service.generator.TariffListGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class GenerateTariffsImpl implements Command {

    static final Logger LOGGER = LogManager.getLogger(GenerateTariffsImpl.class.getName());

    /**
     * Method for calling methods to generate a plausible list of tariffs
     * and exception handling
     * @see Command
     * @see TariffService
     * @see Creator
     * @param request user-selected command
     * @return {@code HashMap} object including tariff generate result or exception
     * @throws ControllerException handled on method {@code execute} invocation
     */
    @Override
    public Map<Boolean, String> execute(String request) throws ControllerException {
        Map<Boolean, String> res = new HashMap<>();
        Generator generator = new TariffListGenerator();
        try{
            LOGGER.trace("GenerateTariffsImpl completed correctly");
            generator.generateRandomDataToFile();
            res.put(true, "Successfully");
        } catch (ServiceException e){
            throw new ControllerException(e);
        }
        return res;
    }
}
