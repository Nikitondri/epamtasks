package by.zakharenko.demothreads.daemonthreads;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleThread extends Thread{

    public void run() {
        try {
            if(isDaemon()){
                System.out.println("Старт потока демона");
                Thread.sleep(0);
            } else {
                System.out.println("Старт обычного потока");
            }
        } catch (InterruptedException e) {
            System.err.println("Error");
        } finally {
            if(!isDaemon()){
                System.out.println("Завершение обычного потока");
            } else {
                System.out.println("Завершение потока демона");
            }
        }
    }
}
