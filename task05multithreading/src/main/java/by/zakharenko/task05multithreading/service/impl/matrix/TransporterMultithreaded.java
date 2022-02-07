package by.zakharenko.task05multithreading.service.impl.matrix;

import by.zakharenko.task05multithreading.entity.Matrix;
import by.zakharenko.task05multithreading.entity.exception.EntityException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

/**
 * class that implements matrix Transposition
 */
public class TransporterMultithreaded {

    static final Logger LOGGER = LogManager.getLogger(TransporterMultithreaded.class.getName());

    /**
     * ExecutorService is used to limit the number of threads
     * method implements multithreaded matrix transposition
     * Each row of the resulting matrix is calculated in a separate thread
     * Due to the situation in which the program may block due to blocking when
     * the barrier is reached and the thread limit, the limit on the strict number
     * of threads is not used. To solve this problem, it would be better to use a {@code CountDownLatch}
     * @see CyclicBarrier
     * @see ExecutorService
     * @see TransporterThread
     * @param matrix original matrix
     * @return transposed matrix
     */
    public Matrix<Integer> transposition(Matrix<Integer> matrix) {
        ExecutorService executorService = Executors.newFixedThreadPool(matrix.getNumRow());
        Matrix<Integer> result = new Matrix<>(new Integer[matrix.getNumColumn()][matrix.getNumRow()]);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(matrix.getNumRow() + 1);
        for (int i = 0; i < matrix.getNumRow(); i++) {
            executorService.execute(new TransporterThread(cyclicBarrier, result, matrix, i));
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            LOGGER.log(Level.WARN, "Transporter Interrupted!", e);
            Thread.currentThread().interrupt();
        }
        executorService.shutdown();
        return result;
    }

    private static class TransporterThread implements Runnable{
        private final CyclicBarrier cyclicBarrier;
        private final Matrix<Integer> result;
        private final Matrix<Integer> matrix;
        private final int row;

        public TransporterThread(CyclicBarrier cyclicBarrier, Matrix<Integer> result, Matrix<Integer> matrix, int row) {
            this.cyclicBarrier = cyclicBarrier;
            this.result = result;
            this.matrix = matrix;
            this.row = row;
        }

        @Override
        public void run() {
            LOGGER.log(Level.TRACE, "TransporterThread {} started", Thread.currentThread().getName());
            for(int j = 0; j < matrix.getNumColumn(); j++) {
                try {
                    result.setElement(j, row, matrix.getElement(row, j));
                } catch (EntityException e) {
                    LOGGER.log(Level.WARN, "Multiplier Interrupted!", e);
                    Thread.currentThread().interrupt();
                }
            }
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException | InterruptedException e) {
                LOGGER.log(Level.WARN, "Multiplier Interrupted!", e);
                Thread.currentThread().interrupt();
            }
            LOGGER.log(Level.TRACE, "TransporterThread {} finished", Thread.currentThread().getName());
        }
    }
}
