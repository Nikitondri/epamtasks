package by.zakharenko.task04oop.service;

import java.util.List;

public interface ParserService<T> {
    List<T> parse(List<String> lines);
}
