package by.zakharanka.task03inheritance.dal.impl;

import by.zakharanka.task03inheritance.dal.JSONDal;
import by.zakharanka.task03inheritance.dal.exception.DalException;
import by.zakharanka.task03inheritance.entity.ParametersList;
import by.zakharanka.task03inheritance.entity.tariff.AllTariffs;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONDalImpl implements JSONDal {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * method parse the json file and fill in the fields of the returned {@code AllTariffs} object
     * @see AllTariffs
     * @param path the path to the file
     * @return {@code AllTariffs} object containing data on all tariffs from a file
     * @throws DalException when throwing an exception
     */
    @Override
    public AllTariffs readTariffsFromJSON(String path) throws DalException {
        try {
            return gson.fromJson(new FileReader(path), AllTariffs.class);
        } catch (FileNotFoundException | JsonSyntaxException e) {
            throw new DalException(e);
        }
    }

    /**
     * method parse the json file and fill in the fields of the returned {@code ParametersList} object
     * @see ParametersList
     * @param path the path to the file
     * @return {@code ParametersList} object containing data on parameters from a file
     * @throws DalException when throwing an exception
     */
    @Override
    public ParametersList readParametersFromJSON(String path) throws DalException {
        try {
            return gson.fromJson(new FileReader(path), ParametersList.class);
        } catch (FileNotFoundException | JsonSyntaxException e) {
            throw new DalException("JSON Dal exception");
        }
    }

    /**
     * method for writing tariff data from an {@code AllTariffs} object to a json file
     * @see AllTariffs
     * @param path the path to the file
     * @param allTariffs contains data on tariffs
     * @throws DalException when throwing an exception
     */
    @Override
    public void writeTariffsToJSON(String path, AllTariffs allTariffs) throws DalException {
        try(FileWriter fileWriter = new FileWriter(path)){
            fileWriter.write(gson.toJson(allTariffs));
            fileWriter.flush();
        } catch (IOException e) {
            throw new DalException(e);
        }
    }
}
