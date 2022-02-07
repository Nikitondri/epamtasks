package by.zakharenko.task05multithreading.service.impl.matrix;

import by.zakharenko.task05multithreading.entity.Matrix;
import by.zakharenko.task05multithreading.entity.exception.EntityException;
import by.zakharenko.task05multithreading.service.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * class that implements matrix multiply
 */
public class MultiplierMultithreaded {
    static final Logger LOGGER = LogManager.getLogger(MultiplierMultithreaded.class.getName());

    /**
     * The method implements multithreaded multiplication of two matrices
     * a {@code CountDownLatch} is used to synchronize the main and child threads in order
     * to wait for the computation to complete before returning the result
     * ExecutorService is used to limit the number of threads
     * Each row of the resulting matrix is calculated in a separate thread
     * In case of an exception in the child thread, the calculations will be performed again
     * @see ExecutorService
     * @see CountDownLatch
     * @param p factor
     * @param q factor
     * @return product
     */
    public Matrix<Integer> multiply(Matrix<Integer> p, Matrix<Integer> q) throws ServiceException {
        int v = p.getNumRow();
        int h = q.getNumColumn();
        int controlSize = p.getNumColumn();
        if (controlSize != q.getNumRow()) {
            throw new ServiceException("incompatible matrices");
        }
        Matrix<Integer> result = new Matrix<>(new Integer[v][h]);
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        boolean isFinished = false;
        int i ;
        CountDownLatch countDownLatch;
        while (!isFinished) {
            countDownLatch = new CountDownLatch(v);
            i = 0;
            while (i < v) {
                executorService.execute(new MultiplyThread(p, q, result, i, countDownLatch));
                i++;
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                LOGGER.log(Level.WARN, "Multiplier Interrupted!", e);
                Thread.currentThread().interrupt();
            }
            isFinished = countDownLatch.getCount() == 0;
        }
        executorService.shutdown();
        return result;
    }

    private static class MultiplyThread implements Runnable{
        private final Matrix<Integer> a;
        private final Matrix<Integer> b;
        private final Matrix<Integer> result;
        private final CountDownLatch countDownLatch;

        private final int threadNumber;

        public MultiplyThread(Matrix<Integer> a, Matrix<Integer> b, Matrix<Integer> result, int threadNumber, CountDownLatch  cdl) {
            this.a = a;
            this.b = b;
            this.result = result;
            this.threadNumber = threadNumber;
            this.countDownLatch = cdl;
        }

        @Override
        public void run() {
            LOGGER.log(Level.TRACE, "Multiply thread {} started", Thread.currentThread().getName());
            int value;
            for(int i = 0; i < a.getNumColumn(); i++){
                value = 0;
                for(int j = 0; j < b.getNumRow(); j++){
                    try {
                        value += a.getElement(threadNumber, j) * b.getElement(j, i);
                    } catch (EntityException e) {
                        LOGGER.log(Level.WARN, "MultiplyThread Interrupted!", e);
                        Thread.currentThread().interrupt();
                    }
                }
                try {
                    result.setElement(threadNumber, i, value);
                } catch (EntityException e) {
                    e.printStackTrace();
                }
            }
            countDownLatch.countDown();
            LOGGER.log(Level.TRACE, "Multiply thread {} finished", Thread.currentThread().getName());
        }
    }
}
