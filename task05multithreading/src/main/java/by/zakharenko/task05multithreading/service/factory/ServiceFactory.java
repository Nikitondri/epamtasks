package by.zakharenko.task05multithreading.service.factory;

import by.zakharenko.task05multithreading.service.MatrixService;
import by.zakharenko.task05multithreading.service.SortService;
import by.zakharenko.task05multithreading.service.impl.MatrixServiceImpl;
import by.zakharenko.task05multithreading.service.impl.SortServiceImpl;

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
