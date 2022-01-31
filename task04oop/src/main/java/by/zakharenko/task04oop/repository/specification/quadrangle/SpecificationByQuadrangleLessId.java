package by.zakharenko.task04oop.repository.specification.quadrangle;

import by.zakharenko.task04oop.repository.specification.CompositeSpecification;
import by.zakharenko.task04oop.entity.Quadrangle;

public class SpecificationByQuadrangleLessId extends CompositeSpecification<Quadrangle> {

    private final long maxId;

    public SpecificationByQuadrangleLessId(long maxId) {
        this.maxId = maxId;
    }

    @Override
    public boolean isSatisfiedBy(Quadrangle candidate) {
        return candidate.getId() < maxId;
    }
}
