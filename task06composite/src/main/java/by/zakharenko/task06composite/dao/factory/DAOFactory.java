package by.zakharenko.task06composite.dao.factory;

import by.zakharenko.task06composite.dao.ReaderDAO;
import by.zakharenko.task06composite.dao.impl.ReaderDaoTxtImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ReaderDAO readerDAOTxt = new ReaderDaoTxtImpl();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public ReaderDAO getReaderDAOTxt(){
        return readerDAOTxt;
    }
}
