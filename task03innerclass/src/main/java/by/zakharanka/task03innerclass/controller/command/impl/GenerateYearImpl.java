package by.zakharanka.task03innerclass.controller.command.impl;

import by.zakharanka.task03innerclass.controller.command.Command;
import by.zakharanka.task03innerclass.controller.exception.ControllerException;
import by.zakharanka.task03innerclass.service.exception.ServiceException;
import by.zakharanka.task03innerclass.service.generator.Generator;
import by.zakharanka.task03innerclass.service.generator.YearGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class GenerateYearImpl implements Command {

    static final Logger LOGGER = LogManager.getLogger(GenerateYearImpl.class.getName());

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
