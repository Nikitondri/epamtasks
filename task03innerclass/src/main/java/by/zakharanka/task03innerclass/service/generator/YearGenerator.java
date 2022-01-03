package by.zakharanka.task03innerclass.service.generator;

import by.zakharanka.task03innerclass.dal.JSONDal;
import by.zakharanka.task03innerclass.dal.exception.DalException;
import by.zakharanka.task03innerclass.dal.factory.DalFactory;
import by.zakharanka.task03innerclass.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class YearGenerator implements Generator {
    private static final String PATH = "src/main/resources/data/year.json";

    static final Logger LOGGER = LogManager.getLogger(YearGenerator.class.getName());

    /**
     * method for generating a plausible year in a json file
     * @throws ServiceException to handle exceptions
     */
    @Override
    public void generateRandomDataToFile() throws ServiceException {
        try{
            DalFactory dalFactory = DalFactory.getInstance();
            JSONDal jsonDal = dalFactory.getJSONFileDal();
            jsonDal.writeYearToJSON(PATH, generateYear());
            LOGGER.trace("year generated");
        } catch (DalException e){
            throw new ServiceException("Error generator");
        }
    }

    private Integer generateYear(){
        Random random = new Random();
        return random.nextInt(22) + 2000;
    }
}
