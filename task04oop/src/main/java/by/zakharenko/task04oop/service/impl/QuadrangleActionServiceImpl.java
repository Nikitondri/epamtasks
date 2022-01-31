package by.zakharenko.task04oop.service.impl;

import by.zakharenko.task04oop.dao.ReaderDAO;
import by.zakharenko.task04oop.dao.exception.DAOException;
import by.zakharenko.task04oop.dao.factory.DAOFactory;
import by.zakharenko.task04oop.dao.util.FileResourcesUtils;
import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.entity.QuadrangleRegistrar;
import by.zakharenko.task04oop.repository.QuadrangleRegistrarRepository;
import by.zakharenko.task04oop.repository.QuadrangleRepository;
import by.zakharenko.task04oop.repository.Repository;
import by.zakharenko.task04oop.service.ParserService;
import by.zakharenko.task04oop.service.QuadrangleActionService;
import by.zakharenko.task04oop.service.RepositoryService;
import by.zakharenko.task04oop.service.comparator.QuadrangleComparatorType;
import by.zakharenko.task04oop.service.comparator.impl.QuadrangleComparatorAreaImpl;
import by.zakharenko.task04oop.service.comparator.impl.QuadrangleComparatorIdImpl;
import by.zakharenko.task04oop.service.comparator.impl.QuadrangleComparatorNameImpl;
import by.zakharenko.task04oop.service.comparator.impl.QuadrangleComparatorPerimeterImpl;
import by.zakharenko.task04oop.service.exception.ServiceException;
import by.zakharenko.task04oop.service.factory.ServiceFactory;
import org.apache.commons.io.FilenameUtils;

import java.util.List;

/**
 * a class that combines actions for operations related to a {@code Quadrangle}
 */
public class QuadrangleActionServiceImpl implements QuadrangleActionService {

    /**
     * a method that adds quads read from a file to the repository, doing validation
     * @see Quadrangle
     * @see QuadrangleRegistrar
     * @see ParserQuadrangleServiceImpl
     * @see ReaderDAO
     * @param path path to file
     * @throws ServiceException in case of error while executing methods
     */
    @Override
    public void addQuadranglesFromFile(String path) throws ServiceException {
        ParserService<Quadrangle> parser = ServiceFactory.getInstance().getParserQuadrangleService();
        RepositoryService<Quadrangle> repositoryService = ServiceFactory.getInstance().getRepositoryQuadrangleService();
        ReaderDAO reader = switch (FilenameUtils.getExtension(path)){
            case "txt" -> DAOFactory.getInstance().getReaderTxtDAO();
            case "json" -> DAOFactory.getInstance().getReaderJSONDAO();
            default -> throw new ServiceException("Incorrect file path");
        };
        FileResourcesUtils util = new FileResourcesUtils();
        try {
            repositoryService.addList(parser.parse(reader.readFile(util.getFileFromResource(path).getPath())));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * a method that creates a comparator and calls a method to sort the quads
     * @see QuadrangleComparatorType
     * @see by.zakharenko.task04oop.service.comparator.QuadrangleComparator
     * @param type sort type
     * @return sorted list
     */
    @Override
    public List<Quadrangle> sort(QuadrangleComparatorType type) {
        Repository<Quadrangle> repository = QuadrangleRepository.getInstance();
        return switch (type){
            case AREA_SORT -> repository.sortByComparator(new QuadrangleComparatorAreaImpl());
            case PERIMETER_SORT -> repository.sortByComparator(new QuadrangleComparatorPerimeterImpl());
            case NAME_SORT -> repository.sortByComparator(new QuadrangleComparatorNameImpl());
            case ID_SORT -> repository.sortByComparator(new QuadrangleComparatorIdImpl());
        };
    }

    @Override
    public void setName(long id, String newName) throws ServiceException {
        RepositoryService<Quadrangle> repositoryService = ServiceFactory.getInstance().getRepositoryQuadrangleService();
        Quadrangle quadrangle = QuadrangleRepository.getInstance().get(id);
        quadrangle.setName(newName);
        repositoryService.set(id, quadrangle);
    }

    @Override
    public void setPoint(long id, Point newPoint, int numPoint) throws ServiceException {
        RepositoryService<Quadrangle> repositoryService = ServiceFactory.getInstance().getRepositoryQuadrangleService();
        Quadrangle quadrangle = QuadrangleRepository.getInstance().get(id);
        switch (numPoint){
            case 1 -> quadrangle.setPointA(newPoint);
            case 2 -> quadrangle.setPointB(newPoint);
            case 3 -> quadrangle.setPointC(newPoint);
            case 4 -> quadrangle.setPointD(newPoint);
            default -> throw new ServiceException("Incorrect numPoint");
        }
        repositoryService.set(id, quadrangle);
    }

    @Override
    public Quadrangle findQuadrangle(long id) {
        return QuadrangleRepository.getInstance().get(id);
    }

    /**
     * method that returns the computed quad parameter stored in the logger
     * @see Quadrangle
     * @see QuadrangleRegistrar
     * @see Repository
     * @param id quadrangles id
     * @param parameterType parameter to be returned
     * @return required parameter
     */
    @Override
    public String findParameter(long id, String parameterType) throws ServiceException {
        QuadrangleRegistrar registrar = QuadrangleRegistrarRepository.getInstance().get(id);
        return switch (parameterType){
            case "perimeter" -> Double.toString(registrar.getPerimeter());
            case "area" -> Double.toString(registrar.getArea());
            case "isConvex" -> Boolean.toString(registrar.isConvex());
            case "quarters" -> registrar.getQuarters().toString();
            case "type" -> registrar.getType().toString();
            default -> throw new ServiceException("Incorrect parameter type");
        };
    }

    @Override
    public boolean removeQuadrangle(long id) {
        RepositoryService<Quadrangle> repositoryService = ServiceFactory.getInstance().getRepositoryQuadrangleService();
        return repositoryService.remove(id);
    }
}
