package by.zakharanka.task03innerclass.controller;

import java.util.Map;

public interface Controller {
    Map<String, Exception> executeAction(String commandName);
}
