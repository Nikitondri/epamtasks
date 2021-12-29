package by.zakharanka.task03inheritance.service.factory;

import by.zakharanka.task03inheritance.service.TariffService;
import by.zakharanka.task03inheritance.service.impl.TariffServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final TariffService tariffService = new TariffServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TariffService getTariffService(){
        return tariffService;
    }


}
