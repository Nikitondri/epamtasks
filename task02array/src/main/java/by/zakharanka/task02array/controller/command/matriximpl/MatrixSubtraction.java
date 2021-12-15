package by.zakharanka.task02array.controller.command.matriximpl;

import by.zakharanka.task02array.controller.command.Command;
import by.zakharanka.task02array.entity.Data;
import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.creator.MatrixCreator;
import by.zakharanka.task02array.service.MatrixService;
import by.zakharanka.task02array.service.exception.ServiceException;
import by.zakharanka.task02array.service.factory.ServiceFactory;

import java.util.HashMap;

public class MatrixSubtraction implements Command {

    @Override
    public HashMap<String, Exception> execute(Data<String> request) {
        HashMap<String, Exception> res = new HashMap<>();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();
        MatrixCreator matrixCreator = new MatrixCreator();
        try{
            Matrix matrix1 = matrixCreator.createMatrix(request.getElement(0), request.getElement(1));
            Matrix matrix2 = matrixCreator.createMatrix(request.getElement(0), request.getElement(1));
            res.put(matrixService.subtraction(matrix1, matrix2), null);
        } catch(ServiceException | EntityException e) {
            res.put(null, e);
            //TODO: add log
        }
        return res;
    }
}
