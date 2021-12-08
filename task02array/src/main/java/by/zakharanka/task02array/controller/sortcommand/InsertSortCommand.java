package by.zakharanka.task02array.controller.sortcommand;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.service.SortService;

public class InsertSortCommand implements SortCommand{

    private final SortService sortService;

    public InsertSortCommand(SortService newSortService) {
        sortService = newSortService;
    }

    @Override
    public void execute(Array array) {
        sortService.insertSort();
    }
}
