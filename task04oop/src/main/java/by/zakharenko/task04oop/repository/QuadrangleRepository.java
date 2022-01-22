package by.zakharenko.task04oop.repository;

import by.zakharenko.task04oop.dal.exception.DAOException;
import by.zakharenko.task04oop.repository.specification.Specification;
import by.zakharenko.task04oop.entity.Quadrangle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuadrangleRepository implements Repository<Quadrangle>{
    private static QuadrangleRepository instance;

    private final List<Quadrangle> storage;

    private QuadrangleRepository(){
        storage = new ArrayList<>();
    }

    public static QuadrangleRepository getInstance(){
        if(instance == null){
            instance = new QuadrangleRepository();
        }
        return instance;
    }

    @Override
    public void add(Quadrangle quadrangle) {
        storage.add(quadrangle); //TODO: set id
        //TODO: добавить регистратор, привязать к сущности
        //TODO: создать репозиторий регистраторов
    }

    @Override
    public List<Quadrangle> findBySpecification(Specification<Quadrangle> specification) {
        List<Quadrangle> quadrangleList = new ArrayList<>();
        for(Quadrangle quadrangle: storage){
            if(specification.isSatisfiedBy(quadrangle)){
                quadrangleList.add(quadrangle);
            }
        }
        return quadrangleList;
    }

    @Override
    public List<Quadrangle> sortByComparator(Comparator<Quadrangle> comparator) {
        return new ArrayList<>(storage).stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public void update(Quadrangle oldQuadrangle, Quadrangle newQuadrangle) throws DAOException {
        if(storage.contains(oldQuadrangle)){
            int oldQuadrangleIndex = storage.indexOf(oldQuadrangle);
            storage.set(oldQuadrangleIndex, newQuadrangle);
        } else {
            throw new DAOException("Not correct oldPerson");
        }
    }

    @Override
    public void remove(long id) {
        for(Quadrangle quadrangle: storage){
            if(quadrangle.getId() == id){
                storage.remove(quadrangle); //TODO: удалить регистратор
                break;
            }
        }
    }
}
