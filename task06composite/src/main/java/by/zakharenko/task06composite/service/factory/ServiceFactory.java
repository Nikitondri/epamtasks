package by.zakharenko.task06composite.service.factory;

import by.zakharenko.task06composite.service.TextService;
import by.zakharenko.task06composite.service.impl.TextServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final TextService textService = new TextServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TextService getTextService(){
        return textService;
    }

}
