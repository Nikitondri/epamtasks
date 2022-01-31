package by.zakharenko.demothreads.countdownawaitthread;

import java.util.concurrent.CountDownLatch;

public class Runner {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Work(countDownLatch).start();
//        new Work(countDownLatch).start();
//        new Work(countDownLatch).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main is finished");
    }
}
