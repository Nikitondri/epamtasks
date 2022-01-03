package by.zakharanka.task03innerclass.service.generator;

import by.zakharanka.task03innerclass.dal.JSONDal;
import by.zakharanka.task03innerclass.dal.exception.DalException;
import by.zakharanka.task03innerclass.dal.factory.DalFactory;
import by.zakharanka.task03innerclass.entity.Date;
import by.zakharanka.task03innerclass.entity.MyCalendar;
import by.zakharanka.task03innerclass.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class DateGenerator implements Generator{
    private static final String PATH = "src/main/resources/data/date.json";

    static final Logger LOGGER = LogManager.getLogger(DateGenerator.class.getName());

    /**
     * method for generating a plausible date in a json file
     * @see Date
     * @throws ServiceException to handle exceptions
     */
    @Override
    public void generateRandomDataToFile() throws ServiceException {
        try{
            DalFactory dalFactory = DalFactory.getInstance();
            JSONDal jsonDal = dalFactory.getJSONFileDal();
            jsonDal.writeDateToJSON(PATH, generateDate());
            LOGGER.trace("date generated");
        } catch (DalException e){
            throw new ServiceException("Error generator");
        }
    }

    private Date generateDate(){
        Random random = new Random();
        int month = random.nextInt(12);
        MyCalendar calendar = MyCalendar.getInstance(2020);
        int day = random.nextInt(calendar.dayInMonth(month) + 1) + 1;
        return new Date(day, month);
    }
}
