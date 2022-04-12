package by.zakharenko.cafe.service.factory;

import by.zakharenko.cafe.service.MenuService;
import by.zakharenko.cafe.service.ReviewService;
import by.zakharenko.cafe.service.UserService;
import by.zakharenko.cafe.service.impl.MenuServiceImpl;
import by.zakharenko.cafe.service.impl.ReviewServiceImpl;
import by.zakharenko.cafe.service.impl.UserServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final MenuService menuService = new MenuServiceImpl();
    private final ReviewService reviewService = new ReviewServiceImpl();
    private final UserService userService = new UserServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public MenuService getMenuService(){
        return menuService;
    }

    public ReviewService getReviewService() {
        return reviewService;
    }

    public UserService getUserService() {
        return userService;
    }
}
