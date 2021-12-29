package by.zakharanka.task03inheritance.dal;

import by.zakharanka.task03inheritance.dal.exception.DalException;
import by.zakharanka.task03inheritance.entity.ParametersList;
import by.zakharanka.task03inheritance.entity.tariff.AllTariffs;

public interface JSONDal {
    AllTariffs readTariffsFromJSON(String path) throws DalException;
    ParametersList readParametersFromJSON(String path) throws DalException;
    void writeTariffsToJSON(String path, AllTariffs allTariffs) throws DalException;
}
