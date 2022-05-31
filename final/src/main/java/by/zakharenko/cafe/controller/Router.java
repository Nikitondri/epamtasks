package by.zakharenko.cafe.controller;

import by.zakharenko.cafe.controller.enumeration.Transition;

public class Router {
    private String page;
    private Transition transition;

    public Router(String page, Transition transition) {
        this.page = page;
        this.transition = transition;
    }

    public Router(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }

    public Transition getTransition() {
        return transition;
    }
}
