package by.zakharenko.demothreads.executorservicethread;

import java.util.Random;
import java.util.concurrent.*;

public class CalcRunner {
    public static void main(String[] args) {
        Future<Number> future = null;
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i++) {
            Callable<Number> callable = new MyCallable();
            future = es.submit(callable);

//            Number number = 0;
//            try {
////                number = future.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//            System.out.println(number);
        }
        es.shutdown();
    }

    static class MyCallable implements Callable<Number>{
        @Override
        public Number call() throws Exception {
            System.out.println("Start: " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Finish: " + Thread.currentThread().getName());
            Number res = new Random().nextGaussian(); // имитация вычислений
            return res;
        }
    }
}
