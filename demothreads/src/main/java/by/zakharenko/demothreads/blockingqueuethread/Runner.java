package by.zakharenko.demothreads.blockingqueuethread;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new PriorityBlockingQueue<>();

        for(int i = 0; i < 10; i++){
            new Thread(){
                @Override
                public void run() {
                    try {
                        System.out.println(blockingQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

            new Thread(){
                @Override
                public void run() {
                    blockingQueue.add("New El");
                }
            }.start();
        }

    }
}
