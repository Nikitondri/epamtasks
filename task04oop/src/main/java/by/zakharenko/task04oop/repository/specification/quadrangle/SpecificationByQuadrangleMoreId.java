package by.zakharenko.task04oop.repository.specification.quadrangle;

import by.zakharenko.task04oop.repository.specification.CompositeSpecification;
import by.zakharenko.task04oop.entity.Quadrangle;

public class SpecificationByQuadrangleMoreId extends CompositeSpecification<Quadrangle> {
    private final long minId;

    public SpecificationByQuadrangleMoreId(long minId) {
        this.minId = minId;
    }

    @Override
    public boolean isSatisfiedBy(Quadrangle candidate) {
        return candidate.getId() > minId;
    }
}
