package by.zakharanka.task02array.entity;

import by.zakharanka.task02array.entity.exception.EntityException;

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

    public void swapElements(int row1, int column1, int row2, int column2){
        T buf;
        buf = m[row1][column1];
        m[row1][column1] = m[row2][column2];
        m[row2][column2] = buf;
    }

    @Override
    public boolean equals(Object o) {
        //TODO: check realization
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
