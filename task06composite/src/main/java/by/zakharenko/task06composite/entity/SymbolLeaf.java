package by.zakharenko.task06composite.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * a class that is a leaf in a composite structure for storing text
 */
public class SymbolLeaf implements TextComponent{
    private static final Logger LOGGER = LogManager.getLogger(SymbolLeaf.class);
    private final char symbol;

    public SymbolLeaf(char newSymbol) {
        symbol = newSymbol;
    }

    @Override
    public void add(TextComponent component) {
        LOGGER.log(Level.ERROR, "Can't call a method add on a class SymbolLeaf");
    }

    @Override
    public void add(int index, TextComponent component) {
        LOGGER.log(Level.ERROR, "Can't call a method add on a class SymbolLeaf");
    }

    @Override
    public List<TextComponent> getComponents() {
        LOGGER.log(Level.ERROR, "Can't call a method getComponents on a class SymbolLeaf");
        return Collections.emptyList();
    }

    @Override
    public void setDelimiter(String delimiter) {
        LOGGER.log(Level.ERROR, "Can't call a method setDelimiter on a class SymbolLeaf");
    }

    @Override
    public int size() {
        LOGGER.log(Level.WARN, "Composite leaves cannot have children");
        return 0;
    }

    @Override
    public char value() {
        return symbol;
    }

    @Override
    public String getDelimiter() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SymbolLeaf that = (SymbolLeaf) o;
        return symbol == that.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}
