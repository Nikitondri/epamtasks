package by.zakharanka.task02array.service.factory;

import by.zakharanka.task02array.service.MatrixService;
import by.zakharanka.task02array.service.SortService;
import by.zakharanka.task02array.service.impl.MatrixServiceImpl;
import by.zakharanka.task02array.service.impl.SortServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final MatrixService matrixService = new MatrixServiceImpl();
    private final SortService sortService = new SortServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public MatrixService getMatrixService() {
        return matrixService;
    }

    public SortService getSortService() {
        return sortService;
    }
}
