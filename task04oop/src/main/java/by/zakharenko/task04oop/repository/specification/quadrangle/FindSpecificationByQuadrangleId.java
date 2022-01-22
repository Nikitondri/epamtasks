package by.zakharenko.task04oop.repository.specification.quadrangle;

import by.zakharenko.task04oop.repository.specification.CompositeSpecification;
import by.zakharenko.task04oop.entity.Quadrangle;

public class FindSpecificationByQuadrangleId extends CompositeSpecification<Quadrangle> {
    private final long id;

    public FindSpecificationByQuadrangleId(long newId){
        id = newId;
    }

    @Override
    public boolean isSatisfiedBy(Quadrangle quadrangle) {
        return quadrangle.getId() == id;
    }
}
