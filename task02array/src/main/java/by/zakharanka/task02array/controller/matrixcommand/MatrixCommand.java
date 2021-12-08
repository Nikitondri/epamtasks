package by.zakharanka.task02array.controller.matrixcommand;

import by.zakharanka.task02array.entity.Matrix;

@FunctionalInterface
public interface MatrixCommand {
    Matrix execute();
}
