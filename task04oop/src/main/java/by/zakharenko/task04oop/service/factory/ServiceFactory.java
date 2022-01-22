package by.zakharenko.task04oop.service.factory;

import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.service.ParserService;
import by.zakharenko.task04oop.service.PointService;
import by.zakharenko.task04oop.service.QuadrangleService;
import by.zakharenko.task04oop.service.ValidatorService;
import by.zakharenko.task04oop.service.impl.ParserQuadrangleServiceImpl;
import by.zakharenko.task04oop.service.impl.PointServiceImpl;
import by.zakharenko.task04oop.service.impl.QuadrangleServiceImpl;
import by.zakharenko.task04oop.service.impl.ValidatorQuadrangleServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final QuadrangleService quadrangleService = new QuadrangleServiceImpl();
    private final PointService pointService = new PointServiceImpl();
    private final ValidatorService validatorQuadrangleService = new ValidatorQuadrangleServiceImpl();
    private final ParserService<Quadrangle> parserQuadrangleService = new ParserQuadrangleServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public QuadrangleService getQuadrangleService(){
        return quadrangleService;
    }

    public PointService getPointService(){
        return pointService;
    }

    public ValidatorService getValidatorQuadrangleService(){
        return validatorQuadrangleService;
    }

    public ParserService<Quadrangle> getParserQuadrangleService(){
        return parserQuadrangleService;
    }
}
