package by.zakharenko.demothreads.atomicthread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicApp {
    static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {
        for(int i = 0; i < 10000; i++){
            new Thread(){
                @Override
                public void run() {
                    num.incrementAndGet();
                }
            }.start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num.get());
    }
}
