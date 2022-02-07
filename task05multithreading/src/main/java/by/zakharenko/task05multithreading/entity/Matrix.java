package by.zakharenko.task05multithreading.entity;

import by.zakharenko.task05multithreading.entity.exception.EntityException;

import java.util.Arrays;

public class Matrix<T extends Number> {

    private final T[][] m;

    public Matrix(T[][] newMatrix){
        m = newMatrix;
    }

    public int getNumRow(){
        return m.length;
    }

    public int getNumColumn(){
        return m[0].length;
    }

    private boolean checkRange(int row, int column){
        return row >= 0 && row < m.length && column >= 0 && column <= m[0].length;
    }

    public T getElement(int row, int column) throws EntityException {
        if(checkRange(row, column)){
            return m[row][column];
        } else {
            throw new EntityException();
        }
    }

    public void setElement(int row, int column, T value) throws EntityException {
        if(checkRange(row, column)){
            m[row][column] = value;
        } else {
            throw new EntityException();
        }
    }

    public T[][] getMatrix(){
        return Arrays.copyOf(m, m.length);
    }

    public void setRow(int numRow, T[] row){
        m[numRow] = row;
    }

    public T[] getRow(int numRow){
        return Arrays.copyOf(m[numRow], m[numRow].length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix<?> matrix = (Matrix<?>) o;
        return Arrays.deepEquals(m, matrix.m);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(m);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Matrix:\n");
        for (T[] ts : m) {
            for (int j = 0; j < m[0].length; j++) {
                res.append(ts[j]).append(" ");
            }
            res.append("\n");
        }
        return res.toString();
    }
}
