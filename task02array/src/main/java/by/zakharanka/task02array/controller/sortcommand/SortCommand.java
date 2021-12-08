package by.zakharanka.task02array.controller.sortcommand;

import by.zakharanka.task02array.entity.Array;

@FunctionalInterface
public interface SortCommand {
    void execute(Array array);
}
