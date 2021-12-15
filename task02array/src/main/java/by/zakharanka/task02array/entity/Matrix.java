package by.zakharanka.task02array.entity;

import by.zakharanka.task02array.entity.exception.EntityException;

import java.util.Arrays;

public class Matrix {

    private int[][] matrix;

    public Matrix(int[][] newMatrix){
        matrix = newMatrix;
    }

    public Matrix(int row, int column) throws EntityException {
        if(row > 1 && column > 1){
            matrix = new int[row][column];
        } else{
            throw new EntityException();
        }
    }

    public int getNumRow(){
        return matrix.length;
    }

    public int getNumColumn(){
        return matrix[0].length;
    }

    private boolean checkRange(int row, int column){
        return row >= 0 && row < matrix.length && column >= 0 && column <= matrix[0].length;
    }

    public int getElement(int row, int column) throws EntityException {
        if(checkRange(row, column)){
            return matrix[row][column];
        } else {
            throw new EntityException();
        }
    }

    public void setElement(int row, int column, int value) throws EntityException {
        if(checkRange(row, column)){
            matrix[row][column] = value;
        } else {
            throw new EntityException();
        }
    }

    public void swapElements(int row1, int column1, int row2, int column2){
        int buf;
        buf = matrix[row1][column1];
        matrix[row1][column1] = matrix[row2][column2];
        matrix[row2][column2] = buf;
    }

    @Override
    public String toString() {
        final String BLANK = " ";
        StringBuilder s = new StringBuilder("\nMatrix : " + matrix.length + "x"
                + matrix[0].length + "\n");
        for(int[] row: matrix){
            for(int value: row){
                s.append(value).append(BLANK);
            }
            s.append("\n");
        }
        return s.toString();
    }
}
