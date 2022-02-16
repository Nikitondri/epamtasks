package by.zakharenko.task06composite.service.converter.rpn;

import by.zakharenko.task06composite.service.converter.Converter;

public interface ConverterRPN extends Converter<String> {
    @Override
    String convert(String expression);
}
