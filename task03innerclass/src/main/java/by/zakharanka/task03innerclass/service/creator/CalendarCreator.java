package by.zakharanka.task03innerclass.service.creator;

import by.zakharanka.task03innerclass.dal.JSONDal;
import by.zakharanka.task03innerclass.dal.exception.DalException;
import by.zakharanka.task03innerclass.dal.factory.DalFactory;
import by.zakharanka.task03innerclass.dal.util.FileResourcesUtils;
import by.zakharanka.task03innerclass.entity.MyCalendar;
import by.zakharanka.task03innerclass.service.exception.ServiceException;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarCreator implements Creator<MyCalendar>{
    public static final String ERROR = "Error creator calendar";

    /**
     * initializes an MyCalendar object with data from a file
     * @see MyCalendar
     * @param path the path to the file
     * @return MyCalendar object with initialized fields
     * @throws ServiceException to handle exceptions
     */
    @Override
    public MyCalendar createFromFile(String path) throws ServiceException {
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        try{
            DalFactory dalFactory = DalFactory.getInstance();
            JSONDal jsonDal = dalFactory.getJSONFileDal();
            File file = fileResourcesUtils.getFileFromResource(path);
            int year = jsonDal.readYearFromJSON(file.getPath());
            MyCalendar calendar = MyCalendar.getInstance(year);
            createRedDays(calendar);
            return calendar;
        } catch (DalException e){
            throw new ServiceException(ERROR);
        }
    }

    /**
     * method for filling red days based on the year
     * @param calendar to fill red days
     */
    public void createRedDays(MyCalendar calendar){
        Calendar cal = new GregorianCalendar(calendar.getYear(), Calendar.JANUARY, 1);
        for(int i = 0; i < calendar.dayOfYear(); i++){
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                calendar.getRedDay().addRedDay(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH), "Day off");
            }
            cal.add(Calendar.DAY_OF_YEAR, 1);
        }
        calendar.getRedDay().addRedDay(1, 0, "New Year");
        calendar.getRedDay().addRedDay(7, 0, "Christmas");
        calendar.getRedDay().addRedDay(23, 1, "February 23");
        calendar.getRedDay().addRedDay(8, 2, "March 8");
        calendar.getRedDay().addRedDay(9, 4, "Victory Day");
        calendar.getRedDay().addRedDay(7, 10, "October Revolution Day");
        calendar.getRedDay().addRedDay(25, 11, "Nativity");
    }
}
