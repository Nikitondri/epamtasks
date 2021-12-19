package by.zakharanka.task02array.view;

import by.zakharanka.task02array.view.exception.ViewException;

import java.io.IOException;
import java.util.Scanner;

public class InputData {

    private final Scanner scanner;

    public InputData() {
        scanner = new Scanner(System.in);
    }

    public int inputInteger(){
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean isCorrect;
        do{
            isCorrect = true;
            try{
                num = Integer.parseInt(sc.nextLine());
            } catch(Exception e){
                isCorrect = false;
            }
        } while(!isCorrect);
        return num;
    }

    public String inputString(){
        return scanner.nextLine();
    }

    public char inputChar() throws ViewException {
        char ch;
        try{
            ch = (char)System.in.read();
        } catch (IOException e){
            throw new ViewException();
        }
        return ch;
    }

}
