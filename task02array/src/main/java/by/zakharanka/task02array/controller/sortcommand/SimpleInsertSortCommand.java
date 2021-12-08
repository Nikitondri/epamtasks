package by.zakharanka.task02array.controller.sortcommand;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.service.SortService;

public class SimpleInsertSortCommand implements SortCommand{

    private final SortService sortService;

    public SimpleInsertSortCommand(SortService newSortService) {
        sortService = newSortService;
    }

    @Override
    public void execute(Array array) {
        sortService.simpleInsertSort();
    }
}
