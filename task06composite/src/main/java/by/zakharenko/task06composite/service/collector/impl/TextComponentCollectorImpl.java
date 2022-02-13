package by.zakharenko.task06composite.service.collector.impl;

import by.zakharenko.task06composite.entity.SymbolLeaf;
import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.service.collector.TextComponentCollector;

public class TextComponentCollectorImpl implements TextComponentCollector {
    @Override
    public String collect(TextComponent component) {
        return collectText(component);
    }

    private String collectText(TextComponent component){
        StringBuilder result = new StringBuilder();
        if(component instanceof SymbolLeaf){
            return Character.toString(component.value());
        } else {
            for (TextComponent childesComponents : component.getComponents()) {
                result.append(childesComponents.getDelimiter());
                result.append(collectText(childesComponents));
            }
        }
        return result.toString();
    }
}
