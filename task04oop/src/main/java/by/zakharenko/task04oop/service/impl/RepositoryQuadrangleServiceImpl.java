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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

/**
 * Service class that performs actions on the {@code Quadrangle} repository
 * @see Quadrangle
 * @see QuadrangleRepository
 */
public class RepositoryQuadrangleServiceImpl implements RepositoryService<Quadrangle> {
    private final Logger logger = LogManager.getLogger(RepositoryQuadrangleServiceImpl.class);

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

    /**
     * method, adds a quad to the repository, generating a new unique id
     * and adding the corresponding registrar to this quad
     * @see Quadrangle
     * @see QuadrangleRegistrar
     * @see QuadrangleRepository
     * @return id
     */
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
        logger.info("Added quadrangle with id: {}", id);
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

    /** a method that removes the quad from the repository and its corresponding registrar */
    @Override
    public boolean remove(long id) {
        if(QuadrangleRepository.getInstance().remove(id)){
            QuadrangleRegistrarRepository.getInstance().remove(id);
            logger.info("Removed quadrangle with id: {}", id);
            return true;
        } else {
            logger.info("Quadrangle not removed due to invalid id");
            return false;
        }
    }

    /**
     * the method that replaces the quads in the repository adds an observer to that quad
     * @param id id
     * @param quadrangle new {@code Quadrangle} object
     * @throws ServiceException in case of an error in the repository or an incorrect quad
     */
    @Override
    public void set(long id, Quadrangle quadrangle) throws ServiceException {
        ValidatorService<Quadrangle> validator = ServiceFactory.getInstance().getValidatorQuadrangleService();
        if(validator.isCorrectObject(quadrangle)) {
            try {
                QuadrangleRepository.getInstance().update(id, quadrangle);
                quadrangle.subscribe(new QuadrangleObserverImpl());
                quadrangle.notifyObservers();
                logger.info("Quadrangle with id {} changed", id);
            } catch (RepositoryException e) {
                throw new ServiceException(e);
            }
        } else {
            throw new ServiceException("Incorrect quadrangle");
        }
    }


}
