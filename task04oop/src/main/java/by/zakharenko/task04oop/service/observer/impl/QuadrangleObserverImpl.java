package by.zakharenko.task04oop.service.observer.impl;

import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.entity.QuadrangleRegistrar;
import by.zakharenko.task04oop.repository.QuadrangleRegistrarRepository;
import by.zakharenko.task04oop.repository.exception.RepositoryException;
import by.zakharenko.task04oop.service.QuadrangleCalculateService;
import by.zakharenko.task04oop.service.exception.ServiceException;
import by.zakharenko.task04oop.service.factory.ServiceFactory;
import by.zakharenko.task04oop.service.observer.Observer;
import by.zakharenko.task04oop.service.observer.QuadrangleEvent;


public class QuadrangleObserverImpl implements Observer<QuadrangleEvent> {
    @Override
    public void update(QuadrangleEvent quadrangleEvent) throws ServiceException {
        Quadrangle quadrangle = quadrangleEvent.getSource();
        long id = quadrangle.getId();
        QuadrangleRegistrar registrar = QuadrangleRegistrarRepository.getInstance().get(id);
        if(registrar == null){
            registrar = new QuadrangleRegistrar();
        }
        QuadrangleCalculateService service = ServiceFactory.getInstance().getQuadrangleCalculateService();
        registrar.setPerimeter(service.findPerimeter(quadrangle));
        registrar.setArea(service.findArea(quadrangle));
        registrar.setConvex(service.isConvex(quadrangle));
        registrar.setQuarters(service.findQuarters(quadrangle));
        registrar.setType(service.determineType(quadrangle));
        try {
            QuadrangleRegistrarRepository.getInstance().update(id, registrar);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
}
