package by.zakharenko.task04oop.dao.factory;

import by.zakharenko.task04oop.dao.ReaderDAO;
import by.zakharenko.task04oop.dao.impl.ReaderJSONDAOImpl;
import by.zakharenko.task04oop.dao.impl.ReaderTxtDAOImpl;

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
