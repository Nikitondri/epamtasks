package by.zakharanka.task03inheritance.view;

import java.util.Map;

public class OutputData {

    public void output(String arg){
        System.out.println(arg);
    }

    /**
     * method to output the result from {@code Map} object
     * if the command is executed successfully, the result is the key
     * on unsuccessful execution of the command, the result is the value containing the exception
     * @param result {@code Map} object with the result of the command
     */
    public void outputResult(Map<Boolean, String> result){
        if (result.containsKey(true)) {
            output(result.get(true));
        } else {
            output(result.get(false));
        }
    }
}
