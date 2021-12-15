package by.zakharanka.task02array.controller.command;

import by.zakharanka.task02array.entity.Data;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.exception.ServiceException;

import java.util.HashMap;

@FunctionalInterface
public interface Command {
    HashMap<String, Exception> execute(Data<String> request) throws ServiceException, EntityException;
}
