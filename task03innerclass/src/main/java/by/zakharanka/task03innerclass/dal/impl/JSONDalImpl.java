package by.zakharanka.task03innerclass.dal.impl;

import by.zakharanka.task03innerclass.dal.JSONDal;
import by.zakharanka.task03innerclass.dal.exception.DalException;
import by.zakharanka.task03innerclass.entity.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONDalImpl implements JSONDal {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Date readDateFromJSON(String path) throws DalException {
        try{
            return gson.fromJson(new FileReader(path), Date.class);
        } catch (FileNotFoundException | JsonSyntaxException e) {
            throw new DalException(e);
        }
    }

    @Override
    public int readYearFromJSON(String path) throws DalException {
        try{
            return gson.fromJson(new FileReader(path), Integer.class);
        } catch (FileNotFoundException | JsonSyntaxException e) {
            throw new DalException(e);
        }
    }

    @Override
    public void writeYearToJSON(String path, Integer year) throws DalException {
        try(FileWriter fileWriter = new FileWriter(path)){
            fileWriter.write(gson.toJson(year));
            fileWriter.flush();
        } catch (IOException e) {
            throw new DalException(e);
        }
    }

    @Override
    public void writeDateToJSON(String path, Date date) throws DalException {
        try(FileWriter fileWriter = new FileWriter(path)){
            fileWriter.write(gson.toJson(date));
            fileWriter.flush();
        } catch (IOException e) {
            throw new DalException(e);
        }
    }
}
