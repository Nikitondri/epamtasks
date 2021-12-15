package by.zakharanka.task02array.view;

import by.zakharanka.task02array.view.exception.ViewException;

import java.io.IOException;
import java.util.Scanner;

public class InputData {

    private Scanner scanner;

    public InputData() {
        scanner = new Scanner(System.in);
    }

//    public int inputInteger(){
//        int num = 0;
//        try{
//            String str = scanner.nextLine();
//            num = Integer.parseInt(str);
//        } catch(Exception e){
//            //TODO: add log
//        }
//        return num;
//    }

    public int inputInteger(){
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean isCorrect;
        do{
            isCorrect = true;
            try{
                num = Integer.parseInt(scanner.nextLine());
            } catch(Exception e){
                isCorrect = false;
            }
        } while(!isCorrect);
        return num;
    }

    public String inputString(){
        return scanner.nextLine();
    }

    public char inputChar(){
        char ch = 0;
        try{
            ch = (char)System.in.read();
        } catch (IOException e){
            //TODO: add log
        }
        return ch;
    }

}
