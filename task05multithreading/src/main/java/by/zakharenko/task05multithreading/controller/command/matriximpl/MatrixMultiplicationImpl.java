package by.zakharenko.task05multithreading.controller.command.matriximpl;

import by.zakharenko.task05multithreading.controller.command.Command;
import by.zakharenko.task05multithreading.controller.command.CommandCallable;
import by.zakharenko.task05multithreading.controller.exception.ControllerException;
import by.zakharenko.task05multithreading.entity.Data;
import by.zakharenko.task05multithreading.entity.Matrix;
import by.zakharenko.task05multithreading.entity.exception.EntityException;
import by.zakharenko.task05multithreading.service.MatrixService;
import by.zakharenko.task05multithreading.service.creator.Creator;
import by.zakharenko.task05multithreading.service.creator.MatrixCreator;
import by.zakharenko.task05multithreading.service.exception.ServiceException;
import by.zakharenko.task05multithreading.service.factory.ServiceFactory;

import java.util.HashMap;

/**
 * Class that runs on a separate thread and calling methods for matrix multiplication
 * @see Command
 * @see CommandCallable
 * @see MatrixService
 */
public class MatrixMultiplicationImpl extends Command {

    public MatrixMultiplicationImpl(Data<String> newRequest) {
        super(newRequest);
    }

    /**
     * Method for calling methods for matrix multiplication and exception handling
     * @see Command
     * @see Data
     * @see MatrixService
     * @return {@code HashMap} object including result result of matrix multiplication or exception
     * @throws ControllerException handled on method {@code execute} invocation
     */
    @Override
    public HashMap<Boolean, String> call() throws ControllerException {
        HashMap<Boolean, String> res = new HashMap<>();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();
        Creator<Matrix<Integer>> matrixCreator = new MatrixCreator();
        try{
            Matrix<Integer> matrix1 = matrixCreator.create(super.getRequest().getElement(0));
            Matrix<Integer> matrix2 = matrixCreator.create(super.getRequest().getElement(1));
            res.put(true, matrixService.multiplication(matrix1, matrix2));
        } catch(ServiceException | EntityException e) {
            throw new ControllerException(e);
        }
        return res;
    }
}
