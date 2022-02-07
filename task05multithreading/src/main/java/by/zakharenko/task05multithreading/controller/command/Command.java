package by.zakharenko.task05multithreading.controller.command;

import by.zakharenko.task05multithreading.entity.Data;

public abstract class Command implements CommandCallable {

    private final Data<String> request;

    protected Command(Data<String> newRequest) {
        request = newRequest;
    }

    public Data<String> getRequest() {
        return new Data<>(request.getList());
    }
}
