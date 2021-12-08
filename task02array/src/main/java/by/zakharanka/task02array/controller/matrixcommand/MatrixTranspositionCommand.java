package by.zakharanka.task02array.controller.matrixcommand;

import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.service.MatrixService;

public class MatrixTranspositionCommand implements MatrixCommand{

    private final MatrixService matrixService;

    public MatrixTranspositionCommand(MatrixService newMatrixService) {
        matrixService = newMatrixService;
    }

    @Override
    public Matrix execute() {
        return matrixService.transposition();
    }
}
