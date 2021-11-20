package by.zakharanka.task01javabasic.controller;

import by.zakharanka.task01javabasic.entity.Data;

public interface Command<T> {

    T exec(Data newData);

}
