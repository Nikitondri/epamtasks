package by.zakharanka.task02array.dal.reader;

import by.zakharanka.task02array.dal.exception.DalException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * a class that implements reading an array from a text file
 * @see DataReader
 */
public class ArrayReader extends DataReader{

    private final BufferedReader br;


    public ArrayReader(String path) throws DalException {
        super(path);
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new DalException("Not correct path file");
        }
    }

    /**
     * a line is read from a file
     * the file is checked for correctness by the method {@code isCorrectPath} of the super class {@code DataReader}
     * @see BufferedReader
     * @see DataReader
     * @return a string containing an array read from a text file
     */
    public String readArray() throws DalException{
        if(!isCorrectPath()){
            throw new DalException("Not Correct file");
        }
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new DalException("Not Correct file");
        }
    }
}
