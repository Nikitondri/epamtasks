package by.zakharenko.task04oop.service.impl;

import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.entity.QuadrangleRegistrar;
import by.zakharenko.task04oop.repository.QuadrangleRegistrarRepository;
import by.zakharenko.task04oop.repository.QuadrangleRepository;
import by.zakharenko.task04oop.repository.Repository;
import by.zakharenko.task04oop.repository.exception.RepositoryException;
import by.zakharenko.task04oop.service.RepositoryService;
import by.zakharenko.task04oop.service.ValidatorService;
import by.zakharenko.task04oop.service.exception.ServiceException;
import by.zakharenko.task04oop.service.factory.ServiceFactory;
import by.zakharenko.task04oop.service.observer.impl.QuadrangleObserverImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class RepositoryQuadrangleServiceImpl implements RepositoryService<Quadrangle> {

    private long generateID(){
        Repository<Quadrangle> repository = QuadrangleRepository.getInstance();
        if(repository.findSize() == 0){
            return 1;
        }
        SortedSet<Long> setId = repository.getSetId();
        long id = 1;
        while(id <= setId.last() + 1){
            if(repository.get(id) == null){
                return id;
            }
            id++;
        }
        if(id == Long.MAX_VALUE){
            return 0;
        }
        return ++id;
    }

    @Override
    public long add(Quadrangle quadrangle) throws ServiceException {
        long id = generateID();
        if(id == 0){
            throw new ServiceException("The repository is full");
        }
        QuadrangleRegistrarRepository.getInstance().add(new QuadrangleRegistrar(id));
        quadrangle.subscribe(new QuadrangleObserverImpl());
        quadrangle.setId(id);
        QuadrangleRepository.getInstance().add(quadrangle);
        return id;
    }

    @Override
    public List<Long> addList(List<Quadrangle> list) throws ServiceException {
        List<Long> listId = new ArrayList<>();
        for (Quadrangle quadrangle: list){
            listId.add(add(quadrangle));
        }
        return listId;
    }

    @Override
    public boolean remove(long id) {
        if(QuadrangleRepository.getInstance().remove(id)){
            QuadrangleRegistrarRepository.getInstance().remove(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void set(long id, Quadrangle quadrangle) throws ServiceException {
        ValidatorService<Quadrangle> validator = ServiceFactory.getInstance().getValidatorQuadrangleService();
        if(validator.isCorrectObject(quadrangle)) {
            try {
                QuadrangleRepository.getInstance().update(id, quadrangle);
            } catch (RepositoryException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Incorrect quadrangle");
        }
    }


}
