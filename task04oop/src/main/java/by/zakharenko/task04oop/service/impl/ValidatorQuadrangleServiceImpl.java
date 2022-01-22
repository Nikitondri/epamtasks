package by.zakharenko.task04oop.service.impl;

import by.zakharenko.task04oop.service.ValidatorService;

public class ValidatorQuadrangleServiceImpl implements ValidatorService {

    @Override
    public boolean isCorrectLine(String line) {
        return line.matches("\\w+(\\s+\\d+\\.\\d+){8}");
    }
}
