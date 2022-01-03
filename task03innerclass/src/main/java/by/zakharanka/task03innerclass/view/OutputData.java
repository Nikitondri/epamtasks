package by.zakharanka.task03innerclass.view;

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
    public void outputResult(Map<String, Exception> result){
        for(String key: result.keySet()){
            if(key != null){
                output(key);
            } else {
                output("Error");
                output(result.get(null).toString());
            }
        }
    }
}
