package by.zakharenko.demothreads.semaphorethread;

import java.util.concurrent.Semaphore;

public class Runner {
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2); // 1 разрешение
        CommonResource res = new CommonResource();
        new Thread(new CountThread(res, sem, "CountThread 1")).start();
        new Thread(new CountThread(res, sem, "CountThread 2")).start();
        new Thread(new CountThread(res, sem, "CountThread 3")).start();
        new Thread(new CountThread(res, sem, "CountThread 4")).start();
        new Thread(new CountThread(res, sem, "CountThread 5")).start();
    }

}
