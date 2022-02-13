package by.zakharenko.task06composite.service.comparator;

import by.zakharenko.task06composite.entity.TextComponent;

import java.util.Comparator;

public interface TextComponentComparator extends Comparator<TextComponent> {
    @Override
    int compare(TextComponent o1, TextComponent o2);
}
