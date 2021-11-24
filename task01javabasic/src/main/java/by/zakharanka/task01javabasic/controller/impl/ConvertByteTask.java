package by.zakharanka.task01javabasic.controller.impl;

import by.zakharanka.task01javabasic.controller.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ConvertService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//34. Дана величина А, выражающая объем информации в байтах. Перевести А в более крупные единицы измерения
//информации

public class ConvertByteTask implements Command {

    private static final String INPUT_BYTE = "Введите кол-во байт: ";
    private static final String TEXT_TASK = "Перевод байт в более крупные единицы измерения информации\n";

    @Override
    public String exec() {
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();
        outputData.output(TEXT_TASK);
        outputData.output(INPUT_BYTE);

//        input data
        long numByte =  inputData.inputLongRange(1, Long.MAX_VALUE);

        ConvertService memoryService = new ConvertService();
        Data<Double> memory = memoryService.convertByte(numByte);
        return "KB: " + memory.getData(0) + "\nMB: " + memory.getData(1) + "\nGB: " +
                memory.getData(2) + "\nTB: " + memory.getData(3) + "\n";
    }
}
