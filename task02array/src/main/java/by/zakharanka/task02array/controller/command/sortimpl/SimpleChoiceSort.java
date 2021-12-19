package by.zakharanka.task02array.controller.command.sortimpl;

import by.zakharanka.task02array.controller.command.Command;
import by.zakharanka.task02array.controller.exception.ControllerException;
import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.entity.Data;
import by.zakharanka.task02array.service.SortService;
import by.zakharanka.task02array.service.creator.ArrayCreator;
import by.zakharanka.task02array.service.exception.ServiceException;
import by.zakharanka.task02array.service.factory.ServiceFactory;
import java.util.HashMap;

/**
 * Class for calling methods for sorting array using simple choice sort
 * @see Command
 * @see SortService
 */
public class SimpleChoiceSort implements Command {

    /**
     * Method for calling methods for sorting array using choice sort and exception handling
     * @see Command
     * @see Data
     * @see SortService
     * @param request data from user including filling method and directly data
     * @return {@code HashMap} object including result result of sorting array or exception
     * @throws ControllerException handled on method {@code execute} invocation
     */
    @Override
    public HashMap<String, Exception> execute(Data<String> request) throws ControllerException {
        HashMap<String, Exception> res = new HashMap<>();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SortService sortService = serviceFactory.getSortService();
        ArrayCreator arrayCreator = new ArrayCreator();
        try{
            Array<Integer> array = arrayCreator.createArray(request.getElement(0), request.getElement(1));
            res.put(sortService.simpleChoiceSort(array), null);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
        return res;
    }
}
