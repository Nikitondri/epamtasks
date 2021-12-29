package by.zakharanka.task03inheritance.controller.command.impl;

import by.zakharanka.task03inheritance.controller.command.Command;
import by.zakharanka.task03inheritance.controller.exception.ControllerException;
import by.zakharanka.task03inheritance.service.exception.ServiceException;
import by.zakharanka.task03inheritance.service.generator.Generator;
import by.zakharanka.task03inheritance.service.generator.TariffListGenerator;

import java.util.HashMap;

public class GenerateTariffsImpl implements Command {
    @Override
    public HashMap<String, Exception> execute(String request) throws ControllerException {
        HashMap<String, Exception> res = new HashMap<>();
        Generator generator = new TariffListGenerator();
        try{
            generator.generateRandomDataToFile();
            res.put("Successfully", null);
        } catch (ServiceException e){
            throw new ControllerException(e);
        }
        return res;
    }
}
