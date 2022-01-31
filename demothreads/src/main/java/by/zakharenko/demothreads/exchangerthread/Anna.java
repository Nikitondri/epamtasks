package by.zakharenko.demothreads.exchangerthread;

import java.util.concurrent.Exchanger;

public class Anna extends Thread{
    Exchanger<String> exchanger;

    public Anna(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println(exchanger.exchange(null));
            System.out.println(exchanger.exchange(null));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
