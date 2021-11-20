package by.zakharanka.task01javabasic.controller.impl;

import by.zakharanka.task01javabasic.controller.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.TimeService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//32. Текущее показание электронных часов: т ч (0 ≤ т ≤23) п мин (0 ≤ п ≤59) к с (0 ≤к ≤59). Какое время будут показывать
//часы через р ч q мин r с?

public class TimerTask implements Command {

    private static final String TEXT_TASK = "Текущее показание электронных часов: т ч (0 ≤ т ≤23) п мин (0 ≤ п ≤59) к с (0 ≤к ≤59).\n" +
            "какое время будут показывать часы через р ч q мин r с?\n";
    private static final String INPUT_HOUR = "Введите часы: ";
    private static final String INPUT_MIN = "Введите минуты: ";
    private static final String INPUT_SEC = "Введите секунды: ";
    private static final String INPUT_ADDED_TIME = "Введите прибавляемое время\n";

    @Override
    public String exec() {
        TimeService timeService = new TimeService();
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();
        outputData.output(TEXT_TASK);

//        input data
//        input current time
        Data<Integer> currTime = inputData.inputTime();
//        input time which will be added
        Data<Integer> time = new Data<>();
        outputData.output(INPUT_ADDED_TIME);
        outputData.output(INPUT_HOUR);
        time.push(inputData.inputInteger());
        outputData.output(INPUT_MIN);
        time.push(inputData.inputInteger());
        outputData.output(INPUT_SEC);
        time.push(inputData.inputInteger());

        Data<Integer> newTime = timeService.checkNewTime(currTime, time);
        return "Часы:" + newTime.getData(0) + " минуты:" + newTime.getData(1)
                + " секунды:" + newTime.getData(2) + "\n";
    }
}