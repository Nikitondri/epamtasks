package by.zakharanka.task03innerclass.controller.command.impl;

import by.zakharanka.task03innerclass.controller.command.Command;
import by.zakharanka.task03innerclass.controller.exception.ControllerException;
import by.zakharanka.task03innerclass.service.CalendarService;
import by.zakharanka.task03innerclass.service.creator.Creator;
import by.zakharanka.task03innerclass.service.exception.ServiceException;
import by.zakharanka.task03innerclass.service.generator.Generator;
import by.zakharanka.task03innerclass.service.generator.YearGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class GenerateYearImpl implements Command {

    static final Logger LOGGER = LogManager.getLogger(GenerateYearImpl.class.getName());

    /**
     * Method for calling methods to generate plausible year to json file
     * and exception handling
     * @see Command
     * @see CalendarService
     * @see Creator
     * @param request user-selected command
     * @return {@code HashMap} object including result or exception
     * @throws ControllerException handled on method {@code execute} invocation
     */
    @Override
    public HashMap<String, Exception> execute(String request) throws ControllerException {
        HashMap<String, Exception> res = new HashMap<>();
        Generator generator = new YearGenerator();
        try{
            LOGGER.trace("GenerateYearImpl completed correctly");
            generator.generateRandomDataToFile();
            res.put("Successfully", null);
        } catch (ServiceException e){
            throw new ControllerException(e);
        }
        return res;
    }
}
