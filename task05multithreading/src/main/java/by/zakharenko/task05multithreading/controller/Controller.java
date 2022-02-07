package by.zakharenko.task05multithreading.controller;

import by.zakharenko.task05multithreading.entity.Data;

import java.util.Map;

public interface Controller {
    Data<Map<Boolean, String>> executeTask(Data<String> commandNameData, Data<Data<String>> requestData);
}
