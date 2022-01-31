package by.zakharenko.demothreads.executorservicethread;

import java.util.Random;
import java.util.concurrent.*;

public class CalcRunner {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Number> future = es.submit(new Callable<Number>() {
            @Override
            public Number call() throws Exception {
                Number res = new Random().nextGaussian(); // имитация вычислений
                return res;
            }
        });
        es.shutdown();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
