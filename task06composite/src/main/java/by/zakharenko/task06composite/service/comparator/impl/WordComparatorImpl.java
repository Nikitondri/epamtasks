package by.zakharenko.task06composite.service.comparator.impl;

import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.service.comparator.TextComponentComparator;

public class WordComparatorImpl implements TextComponentComparator {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return Integer.compare(o1.size(), o2.size());
    }
}
