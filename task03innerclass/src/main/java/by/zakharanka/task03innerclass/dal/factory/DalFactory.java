package by.zakharanka.task03innerclass.dal.factory;

import by.zakharanka.task03innerclass.dal.JSONDal;
import by.zakharanka.task03innerclass.dal.impl.JSONDalImpl;

public class DalFactory {
    private static final DalFactory instance = new DalFactory();

    private final JSONDal JSONFileDal = new JSONDalImpl();

    private DalFactory(){ }

    public static DalFactory getInstance(){
        return instance;
    }

    public JSONDal getJSONFileDal(){
        return JSONFileDal;
    }
}
