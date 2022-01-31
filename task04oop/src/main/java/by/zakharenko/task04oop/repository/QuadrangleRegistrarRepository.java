package by.zakharenko.task04oop.repository;

import by.zakharenko.task04oop.entity.QuadrangleRegistrar;
import by.zakharenko.task04oop.repository.exception.RepositoryException;
import by.zakharenko.task04oop.repository.specification.Specification;

import java.util.*;
import java.util.stream.Collectors;

/**
 * a repository class that stores logger class objects for {@code @QuadrangleRegistrar} objects
 * @see Repository
 * @see by.zakharenko.task04oop.entity.Quadrangle
 * @see QuadrangleRegistrar
 */
public class QuadrangleRegistrarRepository implements Repository<QuadrangleRegistrar>{
    private static QuadrangleRegistrarRepository instance;

    private final List<QuadrangleRegistrar> storage;

    private QuadrangleRegistrarRepository(){
        storage = new ArrayList<>();
    }

    /** thread-unsafe variant of the singleton pattern */
    public static QuadrangleRegistrarRepository getInstance(){
        if(instance == null){
            instance = new QuadrangleRegistrarRepository();
        }
        return instance;
    }

    @Override
    public QuadrangleRegistrar get(long id) {
        for(QuadrangleRegistrar registrar: storage){
            if(registrar.getId() == id){
                return registrar;
            }
        }
        return null;
    }

    /** a method that returns the set of identifiers
     * that the objects in the repository have */
    @Override
    public SortedSet<Long> getSetId() {
        SortedSet<Long> setId = new TreeSet<>();
        for(QuadrangleRegistrar registrar: storage){
            setId.add(registrar.getId());
        }
        return setId;
    }

    @Override
    public void add(QuadrangleRegistrar quadrangleRegistrar) {
        storage.add(quadrangleRegistrar);
    }

    /**
     * method for various search of objects from storage
     * @param specification class objects that inherit from a class {@code CompositeSpecification}
     * @return list of objects matching the specification
     */
    @Override
    public List<QuadrangleRegistrar> findBySpecification(Specification<QuadrangleRegistrar> specification) {
        List<QuadrangleRegistrar> quadrangleRegistrarList = new ArrayList<>();
        for(QuadrangleRegistrar registrar: storage){
            if(specification.isSatisfiedBy(registrar)){
                quadrangleRegistrarList.add(registrar);
            }
        }
        return quadrangleRegistrarList;
    }

    @Override
    public List<QuadrangleRegistrar> sortByComparator(Comparator<QuadrangleRegistrar> comparator) {
        return new ArrayList<>(storage).stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public void update(long id, QuadrangleRegistrar newT) throws RepositoryException {
        try {
            storage.set(storage.indexOf(get(id)), newT);
        } catch (IndexOutOfBoundsException e){
            throw new RepositoryException("Incorrect key in method update QuadrangleRegistrarRepository");
        }
    }

    @Override
    public boolean remove(long id) {
        for(QuadrangleRegistrar registrar: storage){
            if(registrar.getId() == id){
                storage.remove(registrar);
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
