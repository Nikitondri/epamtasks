package by.zakharenko.task04oop.dal.factory;

import by.zakharenko.task04oop.dal.ReaderDAO;
import by.zakharenko.task04oop.dal.impl.ReaderJSONDAOImpl;
import by.zakharenko.task04oop.dal.impl.ReaderTxtDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ReaderDAO readerTxtDAO = new ReaderTxtDAOImpl();
    private final ReaderDAO readerJSONDAO = new ReaderJSONDAOImpl();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public ReaderDAO getReaderTxtDAO(){
        return readerTxtDAO;
    }

    public ReaderDAO getReaderJSONDAO(){
        return readerJSONDAO;
    }


}
