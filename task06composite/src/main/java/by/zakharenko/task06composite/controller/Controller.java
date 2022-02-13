package by.zakharenko.task06composite.controller;

import java.util.List;
import java.util.Map;

public interface Controller {
    Map<Boolean, String> executeAction(List<String> request);
}
