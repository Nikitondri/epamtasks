package by.zakharenko.task05multithreading.service.impl.matrix;

import by.zakharenko.task05multithreading.entity.Matrix;
import by.zakharenko.task05multithreading.service.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * class that implements matrix addition
 */
public class AdderMultithreaded {
    static final Logger LOGGER = LogManager.getLogger(AdderMultithreaded.class.getName());

    /**
     * this method implements multithreaded matrix addition
     * ExecutorService is used to limit the number of threads
     * Each row of the resulting matrix is calculated in a separate callable thread
     * The result of the string calculation is written to the {@code Future} object
     * @see ExecutorService
     * @see by.zakharenko.task05multithreading.service.MatrixService
     * @see Future
     * @param matrix1 matrix to add
     * @param matrix2 matrix to add
     * @return sum
     */
    public Matrix<Integer> addition(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException {
        if(matrix1.getNumRow() != matrix2.getNumRow() || matrix1.getNumColumn() != matrix2.getNumColumn()){
            throw new ServiceException("Not correct sizes Matrix");
        }
        int row = matrix1.getNumRow();
        int column = matrix1.getNumColumn();
        Matrix<Integer> matrixResult = new Matrix<>(new Integer[row][column]);
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Callable<Integer[]>> treads = new ArrayList<>();
        List<Future<Integer[]>> futures = new ArrayList<>();
        for(int i = 0; i < matrixResult.getNumRow(); i++){
            //TODO: оптимизировать, ограничивать кол-во потоков
            treads.add(new AdderThread(matrix1.getRow(i), matrix2.getRow(i)));
        }
        try {
            futures = executorService.invokeAll(treads);
        } catch (InterruptedException e) {
            LOGGER.log(Level.WARN, "AdderThread Interrupted!", e);
            Thread.currentThread().interrupt();
        }
        for(int i = 0; i < matrixResult.getNumRow(); i++){
            try {
                matrixResult.setRow(i, futures.get(i).get());
            } catch (InterruptedException e) {
                LOGGER.log(Level.WARN, "AdderThread Interrupted!", e);
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                throw new ServiceException(e);
            }
        }
        executorService.shutdown();
        return matrixResult;
    }

    private static class AdderThread implements Callable<Integer[]>{
        private final Integer[] row1;
        private final Integer[] row2;

        public AdderThread(Integer[] row1, Integer[] row2) {
            this.row1 = row1;
            this.row2 = row2;
        }

        @Override
        public Integer[] call() throws Exception {
            LOGGER.log(Level.TRACE, "AdderThread {} started", Thread.currentThread().getName());
            Integer[] result = new Integer[row1.length];
            for(int i = 0; i < result.length; i++){
                result[i] = row1[i] + row2[i];
            }
            LOGGER.log(Level.TRACE, "AdderThread {} finished", Thread.currentThread().getName());
            return result;
        }
    }

}
