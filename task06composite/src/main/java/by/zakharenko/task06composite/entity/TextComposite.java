package by.zakharenko.task06composite.entity;

import by.zakharenko.task06composite.service.collector.TextComponentCollector;
import by.zakharenko.task06composite.service.collector.impl.TextComponentCollectorImpl;
import by.zakharenko.task06composite.service.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class TextComposite implements TextComponent{
    private static final Logger LOGGER = LogManager.getLogger(TextComposite.class);
    private final List<TextComponent> components;
    private String delimiter;

    public TextComposite(){
        components = new ArrayList<>();
    }

    public TextComposite(String newDelimiter){
        components = new ArrayList<>();
        delimiter = newDelimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void add(int index, TextComponent component) {
        components.add(index, component);
    }

    @Override
    public boolean remove(TextComponent component) {
        return components.remove(component);
    }

    @Override
    public TextComponent getChild(int index) {
        return components.get(index);
    }

    @Override
    public List<TextComponent> getComponents() {
        return new ArrayList<>(components);
    }

    @Override
    public int size() {
        return components.size();
    }

    @Override
    public char value() {
        LOGGER.log(Level.ERROR, "Only a leaf can have a char value ");
        return '0';
    }

    @Override
    public String getDelimiter() {
        return delimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextComposite that = (TextComposite) o;
        return components.equals(that.components) && delimiter.equals(that.delimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components, delimiter);
    }

    @Override
    public String toString() {
        TextComponentCollector collector = new TextComponentCollectorImpl();
        try {
            return collector.collect(this);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return "";
    }
}
