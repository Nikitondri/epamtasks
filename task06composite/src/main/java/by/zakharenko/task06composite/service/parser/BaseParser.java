package by.zakharenko.task06composite.service.parser;

/**
 * Chain of responsibility pattern for parsing text to store it in a composite structure
 */
public abstract class BaseParser implements Parser{
    private Parser next;

    protected BaseParser(Parser newNext){
        next = newNext;
    }

    public Parser getNext() {
        return next;
    }

    public void setNext(Parser next) {
        this.next = next;
    }
}
