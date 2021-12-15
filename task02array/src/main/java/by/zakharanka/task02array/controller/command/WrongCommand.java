package by.zakharanka.task02array.controller.command;

import by.zakharanka.task02array.entity.Data;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.exception.ServiceException;

import java.util.HashMap;

public class WrongCommand implements Command{
    @Override
    public HashMap<String, Exception> execute(Data<String> request) throws ServiceException, EntityException {
        HashMap<String, Exception> hashMap = new HashMap<>();
        hashMap.put("Wrong Command", null);
        return hashMap;
    }
}
