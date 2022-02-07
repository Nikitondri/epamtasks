package by.zakharenko.task05multithreading.service.impl.matrix;

import by.zakharenko.task05multithreading.entity.Matrix;
import by.zakharenko.task05multithreading.entity.exception.EntityException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Exchanger;

public class MultiplierByNumberMultithreaded {
    static final Logger LOGGER = LogManager.getLogger(MultiplierByNumberMultithreaded.class.getName());

    /**
     * The method implements the multiplication of a matrix by a number
     * Each row of the resulting matrix is calculated in a separate thread
     * To transfer the multiplied row to the resulting matrix, a {@code Exchanger} is used
     * Since the {@code Exchanger} is the synchronization point of the streams, the calculations will occur sequentially
     * To implement this method, it would be better to use other implementation
     * options that would allow the process to be parallelized
     * @see Exchanger
     * @see MultiplierByNumberThread
     * @param matrix original matrix
     * @param num term
     * @return Resulting matrix
     */
    public Matrix<Integer> multiply(Matrix<Integer> matrix, Integer num){
        Matrix<Integer> result = new Matrix<>(new Integer[matrix.getNumColumn()][matrix.getNumRow()]);
        Exchanger<Integer[]> exchanger = new Exchanger<>();
        for(int i = 0; i < matrix.getNumRow(); i++){
            new Thread(new MultiplierByNumberThread(i, num, result, matrix, exchanger)).start();
            try {
                result.setRow(i, exchanger.exchange(null));
            } catch (InterruptedException e) {
                LOGGER.log(Level.WARN, "MultiplierByNumber Interrupted!", e);
                Thread.currentThread().interrupt();
            }
        }
        return result;
    }

    private static class MultiplierByNumberThread implements Runnable{
        private final int numRow;
        private final Integer num;
        private final Matrix<Integer> result;
        private final Matrix<Integer> matrix;
        private final Exchanger<Integer[]> exchanger;

        public MultiplierByNumberThread(int numRow, Integer num, Matrix<Integer> result, Matrix<Integer> matrix, Exchanger<Integer[]> exchanger) {
            this.numRow = numRow;
            this.num = num;
            this.result = result;
            this.matrix = matrix;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            LOGGER.log(Level.TRACE, "MultiplierByNumberThread {} started", Thread.currentThread().getName());
            Integer[] resultRow = new Integer[result.getNumColumn()];
            for(int i = 0; i < result.getNumColumn(); i++){
                try {
                    resultRow[i] = num * matrix.getElement(numRow, i);
                } catch (EntityException e) {
                    LOGGER.log(Level.WARN, "Multiplier Interrupted!", e);
                    Thread.currentThread().interrupt();
                }
            }
            try {
                exchanger.exchange(resultRow);
            } catch (InterruptedException e) {
                LOGGER.log(Level.WARN, "Multiplier Interrupted!", e);
                Thread.currentThread().interrupt();
            }
            LOGGER.log(Level.TRACE, "MultiplierByNumberThread {} finished", Thread.currentThread().getName());
        }
    }
}
