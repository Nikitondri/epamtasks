package by.zakharenko.task07xml.service.factory;

import by.zakharenko.task07xml.service.ParseService;
import by.zakharenko.task07xml.service.impl.ParseServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ParseService parseService = new ParseServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ParseService getParseService(){
        return parseService;
    }
}
