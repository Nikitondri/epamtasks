package by.zakharanka.task03innerclass.view;

import java.util.Scanner;

public class InputData {

    private final Scanner scanner;

    public InputData() {
        scanner = new Scanner(System.in);
    }

    public String inputString(){
        return scanner.nextLine();
    }


}
