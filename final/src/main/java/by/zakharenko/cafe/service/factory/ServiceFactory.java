package by.zakharenko.cafe.service.factory;

import by.zakharenko.cafe.service.MenuService;
import by.zakharenko.cafe.service.impl.MenuServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final MenuService menuService = new MenuServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public MenuService getMenuService(){
        return menuService;
    }
}
