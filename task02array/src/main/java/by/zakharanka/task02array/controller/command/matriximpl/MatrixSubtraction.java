package by.zakharanka.task02array.controller.command.matriximpl;

import by.zakharanka.task02array.controller.command.Command;
import by.zakharanka.task02array.controller.exception.ControllerException;
import by.zakharanka.task02array.entity.Data;
import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.creator.MatrixCreator;
import by.zakharanka.task02array.service.MatrixService;
import by.zakharanka.task02array.service.exception.ServiceException;
import by.zakharanka.task02array.service.factory.ServiceFactory;

import java.util.HashMap;

/**
 * Class for calling methods for matrix subtraction
 * @see Command
 * @see MatrixService
 */
public class MatrixSubtraction implements Command {

    /**
     * Method for calling methods for matrix subtraction and exception handling
     * @see Command
     * @see Data
     * @see MatrixService
     * @param request data from user including filling method and directly data
     * @return {@code HashMap} object including result result of matrix subtraction or exception
     * @throws ControllerException handled on method {@code execute} invocation
     */
    @Override
    public HashMap<String, Exception> execute(Data<String> request) throws ControllerException {
        HashMap<String, Exception> res = new HashMap<>();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();
        MatrixCreator matrixCreator = new MatrixCreator();
        try{
            Matrix<Integer> matrix1 = matrixCreator.createMatrix(request.getElement(0), request.getElement(1));
            Matrix<Integer> matrix2 = matrixCreator.createMatrix(request.getElement(0), request.getElement(2));
            res.put(matrixService.subtraction(matrix1, matrix2), null);
        } catch(ServiceException | EntityException e) {
            throw new ControllerException(e);
        }
        return res;
    }
}
