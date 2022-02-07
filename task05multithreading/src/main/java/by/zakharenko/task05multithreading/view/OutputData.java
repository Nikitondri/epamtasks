package by.zakharenko.task05multithreading.view;

import by.zakharenko.task05multithreading.entity.Data;

import java.util.Map;

public class OutputData {

    public void output(String arg){
        System.out.print(arg);
    }

    public void outputResult(Data<Map<Boolean, String>> resultData){
        for(Map<Boolean, String> result: resultData.getList()) {
            if (result.containsKey(true)) {
                output(result.get(true));
            } else {
                output(result.get(false));
            }
            output("\n\n\n");
        }
    }

}
