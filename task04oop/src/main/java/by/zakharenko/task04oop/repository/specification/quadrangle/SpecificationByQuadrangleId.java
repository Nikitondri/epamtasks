package by.zakharenko.task04oop.repository.specification.quadrangle;

import by.zakharenko.task04oop.repository.specification.CompositeSpecification;
import by.zakharenko.task04oop.entity.Quadrangle;

public class SpecificationByQuadrangleId extends CompositeSpecification<Quadrangle> {
    private final long id;

    public SpecificationByQuadrangleId(long newId){
        id = newId;
    }

    @Override
    public boolean isSatisfiedBy(Quadrangle quadrangle) {
        return quadrangle.getId() == id;
    }
}
