package by.zakharanka.task03innerclass.service.generator;

import by.zakharanka.task03innerclass.dal.JSONDal;
import by.zakharanka.task03innerclass.dal.exception.DalException;
import by.zakharanka.task03innerclass.dal.factory.DalFactory;
import by.zakharanka.task03innerclass.service.exception.ServiceException;

import java.util.Random;

public class YearGenerator implements Generator {
    private static final String PATH = "src/main/resources/data/year.json";

    @Override
    public void generateRandomDataToFile() throws ServiceException {
        try{
            DalFactory dalFactory = DalFactory.getInstance();
            JSONDal jsonDal = dalFactory.getJSONFileDal();
            jsonDal.writeYearToJSON(PATH, generateYear());
        } catch (DalException e){
            throw new ServiceException("Error generator");
        }
    }

    private Integer generateYear(){
        Random random = new Random();
        return random.nextInt(22) + 2000;
    }
}
