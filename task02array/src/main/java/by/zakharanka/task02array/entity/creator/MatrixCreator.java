package by.zakharanka.task02array.entity.creator;

import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.exception.MatrixException;

import java.util.Random;

public class MatrixCreator implements Creator<Matrix> {

    @Override
    public void createFromFile(Matrix object, String path) {
        //TODO: add body
    }

    @Override
    public void createFromKeyboard(Matrix object) {
        //TODO: add body
    }

    @Override
    public void createRandom(Matrix matrix, int maxValue, int minValue) throws MatrixException {
        int rows = matrix.getNumRow();
        int columns = matrix.getNumColumn();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                Random random = new Random();
                matrix.setElement(i, j, (random.nextInt() + minValue) % maxValue);
            }
        }
    }
}
