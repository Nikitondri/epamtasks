package by.zakharanka.task03inheritance.controller;

import java.util.Map;

public interface Controller {
     Map<String, Exception> executeAction(String commandName);
}
