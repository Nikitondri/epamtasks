package by.zakharenko.task04oop.dao.impl;

import by.zakharenko.task04oop.dao.ReaderDAO;
import by.zakharenko.task04oop.dao.exception.DAOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class ReaderJSONDAOImpl implements ReaderDAO {
    @Override
    public List<String> readFile(String path) throws DAOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            return Arrays.asList(gson.fromJson(new FileReader(path), String[].class));
        } catch (FileNotFoundException e) {
            throw new DAOException("ReaderJSONDAOImpl readFile: Incorrect path");
        }
    }
}
