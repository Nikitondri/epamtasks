package by.zakharanka.task03innerclass.controller.command.impl;

import by.zakharanka.task03innerclass.controller.command.Command;
import by.zakharanka.task03innerclass.controller.exception.ControllerException;
import by.zakharanka.task03innerclass.service.CalendarService;
import by.zakharanka.task03innerclass.service.creator.Creator;
import by.zakharanka.task03innerclass.service.exception.ServiceException;
import by.zakharanka.task03innerclass.service.generator.DateGenerator;
import by.zakharanka.task03innerclass.service.generator.Generator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class GenerateDateImpl implements Command {
    static final Logger LOGGER = LogManager.getLogger(GenerateDateImpl.class.getName());

    /**
     * Method for calling methods to generate plausible date to json file
     * and exception handling
     * @see Command
     * @see CalendarService
     * @see Creator
     * @param request user-selected command
     * @return {@code HashMap} object including result or exception
     * @throws ControllerException handled on method {@code execute} invocation
     */
    @Override
    public Map<Boolean, String> execute(String request) throws ControllerException {
        Map<Boolean, String> res = new HashMap<>();
        Generator generator = new DateGenerator();
        try{
            LOGGER.trace("GenerateDateImpl completed correctly");
            generator.generateRandomDataToFile();
            res.put(true, "Successfully");
        } catch (ServiceException e){
            throw new ControllerException(e);
        }
        return res;
    }
}
