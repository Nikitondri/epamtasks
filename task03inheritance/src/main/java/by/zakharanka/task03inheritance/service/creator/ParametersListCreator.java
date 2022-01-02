package by.zakharanka.task03inheritance.service.creator;

import by.zakharanka.task03inheritance.dal.JSONDal;
import by.zakharanka.task03inheritance.dal.exception.DalException;
import by.zakharanka.task03inheritance.dal.factory.DalFactory;
import by.zakharanka.task03inheritance.dal.util.FileResourcesUtils;
import by.zakharanka.task03inheritance.entity.ParametersList;
import by.zakharanka.task03inheritance.service.exception.ServiceException;

import java.io.File;

/**
 * class for initializing {@code ParametersListCreator} object fields
 */
public class ParametersListCreator implements Creator<ParametersList> {
    /**
     * initializes an ParametersList object with data from a file
     * @see ParametersList
     * @param path the path to the file
     * @return ParametersList object with initialized fields
     * @throws ServiceException to handle exceptions
     */
    @Override
    public ParametersList createFromFile(String path) throws ServiceException {
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        try{
            DalFactory dalFactory = DalFactory.getInstance();
            JSONDal jsonDal = dalFactory.getJSONFileDal();
            File file = fileResourcesUtils.getFileFromResource(path);
            return jsonDal.readParametersFromJSON(file.getPath());
        } catch (DalException e){
            throw new ServiceException("Error creator");
        }
    }
}
