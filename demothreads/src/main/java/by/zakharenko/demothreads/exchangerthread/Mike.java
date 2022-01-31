package by.zakharenko.demothreads.exchangerthread;

import java.util.concurrent.Exchanger;

public class Mike extends Thread {
    Exchanger<String> exchanger;

    public Mike(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            exchanger.exchange("Hello, I'm Mike");
            sleep(1000);
            exchanger.exchange("I am 19 y.o.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
