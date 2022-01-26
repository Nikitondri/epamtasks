package by.zakharenko.task04oop.repository;

import by.zakharenko.task04oop.entity.QuadrangleRegistrar;
import by.zakharenko.task04oop.repository.exception.RepositoryException;
import by.zakharenko.task04oop.repository.specification.Specification;

import java.util.*;
import java.util.stream.Collectors;

public class QuadrangleRegistrarRepository implements Repository<QuadrangleRegistrar>{
    private static QuadrangleRegistrarRepository instance;

    private final List<QuadrangleRegistrar> storage;

    private QuadrangleRegistrarRepository(){
        storage = new ArrayList<>();
    }

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
    public void update(QuadrangleRegistrar oldRegistrar, QuadrangleRegistrar newRegistrar) throws RepositoryException {
        if(storage.contains(oldRegistrar)){
            int oldQuadrangleIndex = storage.indexOf(oldRegistrar);
            storage.set(oldQuadrangleIndex, newRegistrar);
        } else {
            throw new RepositoryException("Not correct oldRegistrar");
        }
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
