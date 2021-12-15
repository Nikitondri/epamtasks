package by.zakharanka.task02array.controller.command.sortimpl;

import by.zakharanka.task02array.controller.command.Command;
import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.entity.Data;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.SortService;
import by.zakharanka.task02array.service.creator.ArrayCreator;
import by.zakharanka.task02array.service.exception.ServiceException;
import by.zakharanka.task02array.service.factory.ServiceFactory;
import by.zakharanka.task02array.service.impl.SortServiceImpl;

import java.util.HashMap;

public class BubbleSort implements Command {
    @Override
    public HashMap<String, Exception> execute(Data<String> request) throws ServiceException, EntityException {
        HashMap<String, Exception> res = new HashMap<>();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SortService sortService = serviceFactory.getSortService();
        ArrayCreator arrayCreator = new ArrayCreator();
        try{
            Array<Integer> array = arrayCreator.createArray(request.getElement(0), request.getElement(1));
            res.put(sortService.bubbleSort(array), null);
        } catch (ServiceException e) {
            res.put(null, e);
        }
        return res;
    }
}

