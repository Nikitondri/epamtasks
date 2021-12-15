package by.zakharanka.task02array.dal.reader;

import by.zakharanka.task02array.dal.exception.DalException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArrayReader extends DataReader{

    private final BufferedReader br;

    public ArrayReader(String path) throws DalException {
        super(path);
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new DalException(e);
        }
    }

    public String readArray() throws DalException{
        if(!isCorrectPath()){
            throw new DalException();
        }
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new DalException(e);
        }
    }
}
