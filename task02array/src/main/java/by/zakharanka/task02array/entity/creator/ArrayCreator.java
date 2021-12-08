package by.zakharanka.task02array.entity.creator;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.exception.MatrixException;

public class ArrayCreator implements Creator<Array> {
    @Override
    public void createFromFile(Array object, String path) {
        //TODO: add body
    }

    @Override
    public void createFromKeyboard(Array object) {
        //TODO: add body
    }

    @Override
    public void createRandom(Array object, int maxValue, int minValue) throws MatrixException {
        //TODO: add body
    }
}
