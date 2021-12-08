package by.zakharanka.task02array.controller.sortcommand;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.service.SortService;

public class SimpleChoiceSortCommand implements SortCommand{

    private final SortService sortService;

    public SimpleChoiceSortCommand(SortService newSortService) {
        sortService = newSortService;
    }

    @Override
    public void execute(Array array) {
        sortService.simpleChoiceSort();
    }
}
