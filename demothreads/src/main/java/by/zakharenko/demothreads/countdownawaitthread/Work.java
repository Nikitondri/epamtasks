package by.zakharenko.demothreads.countdownawaitthread;

import java.util.concurrent.CountDownLatch;

public class Work extends Thread {
    CountDownLatch countDownLatch;

    public Work(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run(){
        for(int i = 0; i < 3; i++){
            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cycle " + i);
            countDownLatch.countDown();
        }
    }
}
