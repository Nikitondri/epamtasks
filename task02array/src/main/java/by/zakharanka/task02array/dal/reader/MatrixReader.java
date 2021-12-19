package by.zakharanka.task02array.dal.reader;

import by.zakharanka.task02array.dal.exception.DalException;
import by.zakharanka.task02array.entity.Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * a class that implements reading an matrix from a text file
 * @see DataReader
 */
public class MatrixReader extends DataReader{

    private final BufferedReader br;

    public MatrixReader(String path) throws DalException {
        super(path);
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new DalException("Not correct path file");
        }
    }

    /**
     * a matrix is read from a file
     * the file is checked for correctness by the method {@code isCorrectPath} of the super class {@code DataReader}
     * the correctness of the matrix dimensions is checked
     * @see BufferedReader
     * @see DataReader
     * @return a string containing an matrix read from a text file
     */
    public Data<String> readMatrix() throws DalException{
        if(!isCorrectPath()){
            throw new DalException("not correct file");
        }
        Data<String> data = new Data<>();
        try {
            String line = br.readLine();
            while (line != null) {
                data.put(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new DalException("not correct file");
        }
        if(data.findSize() < 2){
            throw new DalException("Not correct size Matrix");
        }
        int columns = data.getElement(0).split("").length;
        for(int i = 0; i < data.findSize(); i++){
            if(data.getElement(i).split("").length != columns ){
                throw new DalException("Not correct matrix in file");
            }
        }
        return data;
    }

}
