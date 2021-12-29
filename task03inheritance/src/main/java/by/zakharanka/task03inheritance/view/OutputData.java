package by.zakharanka.task03inheritance.view;

import java.util.Map;

public class OutputData {

    public void output(String arg){
        System.out.println(arg);
    }

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
