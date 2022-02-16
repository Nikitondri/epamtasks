package by.zakharenko.task06composite.entity;

import java.util.List;

public interface TextComponent {
    void add(TextComponent component);
    void add(int index, TextComponent component);
    List<TextComponent> getComponents();
    void setDelimiter(String delimiter);
    String getDelimiter();
    int size();
    char value();
}
