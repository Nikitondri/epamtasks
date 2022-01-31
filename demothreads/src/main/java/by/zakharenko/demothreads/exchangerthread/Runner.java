package by.zakharenko.demothreads.exchangerthread;

import java.util.concurrent.Exchanger;

public class Runner {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Mike mike = new Mike(exchanger);
        Anna anna = new Anna(exchanger);
        mike.start();
        anna.start();
    }
}
