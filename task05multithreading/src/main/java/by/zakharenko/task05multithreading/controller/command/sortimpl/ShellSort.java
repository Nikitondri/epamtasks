package by.zakharenko.task05multithreading.controller.command.sortimpl;

import by.zakharenko.task05multithreading.controller.command.Command;
import by.zakharenko.task05multithreading.controller.command.CommandCallable;
import by.zakharenko.task05multithreading.controller.exception.ControllerException;
import by.zakharenko.task05multithreading.entity.Array;
import by.zakharenko.task05multithreading.entity.Data;
import by.zakharenko.task05multithreading.service.SortService;
import by.zakharenko.task05multithreading.service.creator.ArrayCreator;
import by.zakharenko.task05multithreading.service.creator.Creator;
import by.zakharenko.task05multithreading.service.exception.ServiceException;
import by.zakharenko.task05multithreading.service.factory.ServiceFactory;

import java.util.HashMap;

/**
 * Class that runs on a separate thread and calling methods for sorting array using shell sort
 * @see Command
 * @see CommandCallable
 * @see SortService
 */
public class ShellSort extends Command {

    public ShellSort(Data<String> newRequest) {
        super(newRequest);
    }

    /**
     * Method for calling methods for sorting array using shell sort and exception handling
     * @see Command
     * @see Data
     * @see SortService
     * @return {@code HashMap} object including result result of sorting array or exception
     * @throws ControllerException handled on method {@code execute} invocation
     */
    @Override
    public HashMap<Boolean, String> call() throws ControllerException {
        HashMap<Boolean, String> res = new HashMap<>();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SortService sortService = serviceFactory.getSortService();
        Creator<Array<Integer>> arrayCreator = new ArrayCreator();
        try{
            Array<Integer> array = arrayCreator.create(super.getRequest().getElement(0));
            res.put(true, sortService.shellSort(array));
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
        return res;
    }
}
