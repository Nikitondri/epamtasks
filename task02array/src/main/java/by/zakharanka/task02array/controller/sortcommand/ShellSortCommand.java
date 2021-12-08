package by.zakharanka.task02array.controller.sortcommand;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.service.SortService;

public class ShellSortCommand implements SortCommand{

    private final SortService sortService;

    public ShellSortCommand(SortService newSortService) {
        sortService = newSortService;
    }

    @Override
    public void execute(Array array) {
        sortService.shellSort();
    }
}
