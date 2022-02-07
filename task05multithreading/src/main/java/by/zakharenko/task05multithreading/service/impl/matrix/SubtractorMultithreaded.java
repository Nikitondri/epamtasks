package by.zakharenko.task05multithreading.service.impl.matrix;

import by.zakharenko.task05multithreading.entity.Matrix;
import by.zakharenko.task05multithreading.entity.exception.EntityException;
import by.zakharenko.task05multithreading.service.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

/**
 * class that implements matrix subtraction
 */
public class SubtractorMultithreaded {
    static final Logger LOGGER = LogManager.getLogger(SubtractorMultithreaded.class.getName());

    /**
     * The method implements the multithreading difference of two matrices
     * a {@code Semaphore} is used to limit the number of threads created
     * A {@code Phaser} is used to synchronize the main and child threads
     * Each row of the resulting matrix is calculated in a separate thread
     * @see Semaphore
     * @see Phaser
     * @see SubtractThread
     * @param matrix1 Decreased
     * @param matrix2 Subtracted
     * @return Difference
     */
    public Matrix<Integer> subtract(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException {
        if(matrix1.getNumRow() != matrix2.getNumRow() || matrix1.getNumColumn() != matrix2.getNumColumn()){
            throw new ServiceException("Error");
        }
        int row = matrix1.getNumRow();
        int column = matrix1.getNumColumn();
        Matrix<Integer> matrixResult = new Matrix<>(new Integer[row][column]);
        Semaphore semaphore = new Semaphore(Runtime.getRuntime().availableProcessors());
        Phaser phaser = new Phaser();
        phaser.register();
        for(int i = 0; i < matrixResult.getNumRow(); i++){
            new Thread(new SubtractThread(i, matrix1, matrix2, matrixResult, semaphore, phaser)).start();
        }
        phaser.arriveAndAwaitAdvance();
        return matrixResult;
    }

    private static class SubtractThread implements Runnable{
        private final int numRow;
        private final Matrix<Integer> matrix1;
        private final Matrix<Integer> matrix2;
        private final Matrix<Integer> result;
        private final Semaphore semaphore;
        private final Phaser phaser;

        public SubtractThread(int numRow, Matrix<Integer> matrix1, Matrix<Integer> matrix2, Matrix<Integer> result, Semaphore semaphore, Phaser phaser) {
            this.numRow = numRow;
            this.matrix1 = matrix1;
            this.matrix2 = matrix2;
            this.result = result;
            this.semaphore = semaphore;
            this.phaser = phaser;
            phaser.register();
        }

        @Override
        public void run() {
            LOGGER.log(Level.TRACE, "SubtractThread {} started", Thread.currentThread().getName());
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                LOGGER.log(Level.WARN, "SubtractThread Interrupted!", e);
                Thread.currentThread().interrupt();
            }

            for(int i = 0; i < result.getNumColumn(); i++){
                try {
                    result.setElement(numRow, i, matrix1.getElement(numRow, i) - matrix2.getElement(numRow, i));
                } catch (EntityException e) {
                    e.printStackTrace();
                }
            }
            semaphore.release();
            phaser.arrive();
            LOGGER.log(Level.TRACE, "SubtractThread {} finished", Thread.currentThread().getName());
        }
    }


}
