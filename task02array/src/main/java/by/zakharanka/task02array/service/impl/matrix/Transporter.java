package by.zakharanka.task02array.service.impl.matrix;

import by.zakharanka.task02array.entity.Matrix;

public class Transporter {
    public Matrix transposition(Matrix matrix){
        for(int i = 0; i < matrix.getNumRow(); i++){
            for(int j = i; j < matrix.getNumColumn(); j++){
                matrix.swapElements(i, j, j, i);
            }
        }
        return matrix;
    }
}
