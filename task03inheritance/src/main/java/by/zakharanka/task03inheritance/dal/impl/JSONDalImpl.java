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

    @Override
    public AllTariffs readTariffsFromJSON(String path) throws DalException {
        try {
            return gson.fromJson(new FileReader(path), AllTariffs.class);
        } catch (FileNotFoundException | JsonSyntaxException e) {
            throw new DalException(e);
        }
    }

    @Override
    public ParametersList readParametersFromJSON(String path) throws DalException {
        try {
            return gson.fromJson(new FileReader(path), ParametersList.class);
        } catch (FileNotFoundException | JsonSyntaxException e) {
            throw new DalException("JSON Dal exception");
        }
    }

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
