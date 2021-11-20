package by.zakharanka.task01javabasic.view;

import by.zakharanka.task01javabasic.entity.Data;
import java.util.Scanner;

public class InputData {

    public Double input(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    public Integer inputRange(final int numRange){
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect;
        int num;
        do{
            isCorrect = true;
            num = scanner.nextInt();
            if(num > numRange){
                isCorrect = false;
            }
        } while(!isCorrect);
        return num;
    }


//    public Data<T> input(Data<T> data, int num){
//        for(int i = 0; i < num; i++){
//            data.push(input((Double) data.getData(i)));
//        }
//        return data;
//    }
}
