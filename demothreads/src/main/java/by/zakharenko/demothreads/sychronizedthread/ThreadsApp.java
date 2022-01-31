package by.zakharenko.demothreads.sychronizedthread;

import by.zakharenko.demothreads.threadcommonresource.CommonResource;
import by.zakharenko.demothreads.threadcommonresource.CountThread;

public class ThreadsApp {
    public static void main(String[] args) {

        CommonResource commonResource= new CommonResource();
        for (int i = 1; i < 6; i++){

            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Поток "+ i);
            t.start();
        }
    }
}
