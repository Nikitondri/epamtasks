package by.zakharenko.task05multithreading.dal.factory;

import by.zakharenko.task05multithreading.dal.ArrayDal;
import by.zakharenko.task05multithreading.dal.MatrixDal;
import by.zakharenko.task05multithreading.dal.impl.TxtFileArrayDal;
import by.zakharenko.task05multithreading.dal.impl.TxtFileMatrixDal;

public class DalFactory {
    private static final DalFactory instance = new DalFactory();

    private final MatrixDal txtFileMatrixDal = new TxtFileMatrixDal();
    private final ArrayDal txtFileArrayDal = new TxtFileArrayDal();

    private DalFactory(){ }

    public static DalFactory getInstance(){
        return instance;
    }

    public MatrixDal getTxtFileMatrixDal(){
        return txtFileMatrixDal;
    }
    public ArrayDal getTxtFileArrayDal(){
        return txtFileArrayDal;
    }
}
