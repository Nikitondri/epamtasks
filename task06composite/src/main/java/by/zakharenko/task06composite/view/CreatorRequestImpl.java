package by.zakharenko.task06composite.view;

import by.zakharenko.task06composite.controller.command.CommandName;

import java.util.ArrayList;
import java.util.List;

public class CreatorRequestImpl implements CreatorRequest{
    private final OutputData outputData = new OutputData();
    private final InputData inputData = new InputData();
    private static final String INPUT_PATH = "Input path: ";

    @Override
    public List<String> create() {
        outputData.output("Choice the task:\n1) collect text\n2) sort paragraph\n3) sort word\n4) sort lexemes\nInput:");
        return switch (inputData.inputString()){
            case "1" -> createCollectTextRequest();
            case "2" -> createSortParagraphRequest();
            case "3" -> createSortWordRequest();
            case "4" -> createSortLexemesRequest();
            default -> createWrongRequest();
        };
    }

    private List<String> createSortLexemesRequest(){
        List<String> list = new ArrayList<>();
        list.add(CommandName.SORT_LEXEME.toString());
        outputData.output(INPUT_PATH);
        list.add(inputData.inputString());
        outputData.output("Input symbol: ");
        list.add(inputData.inputString());
        return list;
    }

    private List<String> createSortParagraphRequest(){
        List<String> list = new ArrayList<>();
        list.add(CommandName.SORT_PARAGRAPH.toString());
        outputData.output(INPUT_PATH);
        list.add(inputData.inputString());
        return list;
    }

    private List<String> createSortWordRequest(){
        List<String> list = new ArrayList<>();
        list.add(CommandName.SORT_WORD.toString());
        outputData.output(INPUT_PATH);
        list.add(inputData.inputString());
        return list;
    }

    private List<String> createCollectTextRequest(){
        List<String> list = new ArrayList<>();
        list.add(CommandName.COLLECT_TEXT.toString());
        outputData.output(INPUT_PATH);
        list.add(inputData.inputString());
        return list;
    }

    private List<String> createWrongRequest(){
        List<String> list = new ArrayList<>();
        list.add(CommandName.WRONG_COMMAND.toString());
        return list;
    }
}
