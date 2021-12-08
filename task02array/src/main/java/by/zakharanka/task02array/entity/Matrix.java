package by.zakharanka.task02array.entity;

import by.zakharanka.task02array.exception.MatrixException;

import java.util.Arrays;

public class Matrix<T> {

    private T[][] matrix;

    public Matrix(T[][] newMatrix){
        matrix = newMatrix;
    }

//    public Matrix(int row, int column) throws MatrixException {
//        if(row > 1 && column > 1){
//            matrix = new int[row][column];
//        } else{
//            throw new MatrixException();
//        }
//    }

    public int getNumRow(){
        return matrix.length;
    }

    public int getNumColumn(){
        return matrix[0].length;
    }

    private boolean checkRange(int row, int column){
        return row >= 0 && row < matrix.length && column >= 0 && column <= matrix[0].length;
    }

    public T getElement(int row, int column) throws MatrixException {
        if(checkRange(row, column)){
            return matrix[row][column];
        } else {
            throw new MatrixException();
        }
    }

    public void setElement(int row, int column, T value) throws MatrixException{
        if(checkRange(row, column)){
            matrix[row][column] = value;
        } else {
            throw new MatrixException();
        }
    }

    @Override
    public String toString() {
        final String BLANK = " ";
        StringBuilder s = new StringBuilder("\nMatrix : " + matrix.length + "x"
                + matrix[0].length + "\n");
        for(T[] row: matrix){
            for(T value: row){
                s.append(value).append(BLANK);
            }
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix<?> matrix1 = (Matrix<?>) o;
        return Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }
}
