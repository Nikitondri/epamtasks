package by.zakharanka.task03innerclass.service.creator;

import by.zakharanka.task03innerclass.dal.JSONDal;
import by.zakharanka.task03innerclass.dal.exception.DalException;
import by.zakharanka.task03innerclass.dal.factory.DalFactory;
import by.zakharanka.task03innerclass.dal.util.FileResourcesUtils;
import by.zakharanka.task03innerclass.entity.Date;
import by.zakharanka.task03innerclass.service.exception.ServiceException;

import java.io.File;

public class DateCreator implements Creator<Date>{
    /**
     * initializes an {@code Date} object with data from a file
     * @see Date
     * @param path the path to the file
     * @return {@code Date} object with initialized fields
     * @throws ServiceException to handle exceptions
     */
    @Override
    public Date createFromFile(String path) throws ServiceException {
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        try{
            DalFactory dalFactory = DalFactory.getInstance();
            JSONDal jsonDal = dalFactory.getJSONFileDal();
            File file = fileResourcesUtils.getFileFromResource(path);
            return jsonDal.readDateFromJSON(file.getPath());
        } catch (DalException e){
            throw new ServiceException("Error creator date");
        }
    }
}
