package by.zakharenko.task04oop.service.factory;

import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.service.*;
import by.zakharenko.task04oop.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final QuadrangleCalculateService quadrangleCalculateService = new QuadrangleCalculateServiceImpl();
    private final PointService pointService = new PointServiceImpl();
    private final ValidatorService<Quadrangle> validatorQuadrangleService = new ValidatorQuadrangleServiceImpl();
    private final ParserService<Quadrangle> parserQuadrangleService = new ParserQuadrangleServiceImpl();
    private final RepositoryService<Quadrangle> repositoryQuadrangleService = new RepositoryQuadrangleServiceImpl();
    private final QuadrangleActionService quadrangleActionService = new QuadrangleActionServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public QuadrangleCalculateService getQuadrangleCalculateService(){
        return quadrangleCalculateService;
    }

    public PointService getPointService(){
        return pointService;
    }

    public ValidatorService<Quadrangle> getValidatorQuadrangleService(){
        return validatorQuadrangleService;
    }

    public ParserService<Quadrangle> getParserQuadrangleService(){
        return parserQuadrangleService;
    }

    public RepositoryService<Quadrangle> getRepositoryQuadrangleService(){
        return repositoryQuadrangleService;
    }

    public QuadrangleActionService getQuadrangleActionService(){
        return quadrangleActionService;
    }
}
