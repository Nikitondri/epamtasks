package by.zakharenko.task04oop.repository;

import by.zakharenko.task04oop.repository.exception.RepositoryException;
import by.zakharenko.task04oop.repository.specification.Specification;
import by.zakharenko.task04oop.entity.Quadrangle;

import java.util.*;
import java.util.stream.Collectors;

/**
 * a repository class that stores logger class objects for {@code @Quadrangle} objects
 * @see Repository
 * @see by.zakharenko.task04oop.entity.Quadrangle
 */
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
        storage.add(quadrangle);
    }

    @Override
    public Quadrangle get(long id) {
        for(Quadrangle quadrangle: storage){
            if(quadrangle.getId() == id){
                return quadrangle;
            }
        }
        return null;
    }

    /** a method that returns the set of identifiers
     * that the objects in the repository have */
    @Override
    public SortedSet<Long> getSetId() {
        SortedSet<Long> setId = new TreeSet<>();
        for(Quadrangle quadrangle: storage){
            setId.add(quadrangle.getId());
        }
        return setId;
    }

    /**
     * method for various search of objects from storage
     * @param specification class objects that inherit from a class {@code CompositeSpecification}
     * @return list of objects matching the specification
     */
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
    public void update(long id, Quadrangle newT) throws RepositoryException {
        try {
            storage.set(storage.indexOf(get(id)), newT);
        } catch (NullPointerException e){
            throw new RepositoryException("Incorrect key in method update QuadrangleRepository");
        }
    }

    @Override
    public boolean remove(long id) {
        for(Quadrangle quadrangle: storage){
            if(quadrangle.getId() == id){
                storage.remove(quadrangle);
                return true;
            }
        }
        return false;
    }

    @Override
    public int findSize() {
        return storage.size();
    }
}
