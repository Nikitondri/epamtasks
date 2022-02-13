package by.zakharenko.task06composite.service.parser;

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
