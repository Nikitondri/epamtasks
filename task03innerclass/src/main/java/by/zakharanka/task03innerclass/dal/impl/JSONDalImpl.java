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
    public static final String ERROR = "Dal error";

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * method parse the json file and fill in the fields of the returned {@code AllTariffs} object
     * @see Date
     * @param path the path to the file
     * @return {@code Date} object containing data on date from a file
     * @throws DalException when throwing an exception
     */
    @Override
    public Date readDateFromJSON(String path) throws DalException {
        try{
            return gson.fromJson(new FileReader(path), Date.class);
        } catch (FileNotFoundException | JsonSyntaxException e) {
            throw new DalException(ERROR);
        }
    }

    /**
     * method parse the json file and fill in the fields of the returned int variable
     * @param path the path to the file
     * @return int variable containing year from a file
     * @throws DalException when throwing an exception
     */
    @Override
    public int readYearFromJSON(String path) throws DalException {
        try{
            return gson.fromJson(new FileReader(path), Integer.class);
        } catch (FileNotFoundException | JsonSyntaxException e) {
            throw new DalException(ERROR);
        }
    }

    /**
     * method for writing year from an Integer variable to a json file
     * @param path the path to the file
     * @param year contains year
     * @throws DalException when throwing an exception
     */
    @Override
    public void writeYearToJSON(String path, Integer year) throws DalException {
        try(FileWriter fileWriter = new FileWriter(path)){
            fileWriter.write(gson.toJson(year));
            fileWriter.flush();
        } catch (IOException e) {
            throw new DalException(ERROR);
        }
    }

    /**
     * method for writing date from an {@code Date} object to a json file
     * @see Date
     * @param path the path to the file
     * @param date {@code Date} object contains date
     * @throws DalException when throwing an exception
     */
    @Override
    public void writeDateToJSON(String path, Date date) throws DalException {
        try(FileWriter fileWriter = new FileWriter(path)){
            fileWriter.write(gson.toJson(date));
            fileWriter.flush();
        } catch (IOException e) {
            throw new DalException(ERROR);
        }
    }
}
