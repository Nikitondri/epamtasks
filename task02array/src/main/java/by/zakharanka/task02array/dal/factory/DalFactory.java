package by.zakharanka.task02array.dal.factory;

import by.zakharanka.task02array.dal.ArrayDal;
import by.zakharanka.task02array.dal.MatrixDal;
import by.zakharanka.task02array.dal.impl.TxtFileArrayDal;
import by.zakharanka.task02array.dal.impl.TxtFileMatrixDal;

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
