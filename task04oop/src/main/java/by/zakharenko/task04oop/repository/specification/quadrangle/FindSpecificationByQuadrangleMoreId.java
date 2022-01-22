package by.zakharenko.task04oop.repository.specification.quadrangle;

import by.zakharenko.task04oop.repository.specification.CompositeSpecification;
import by.zakharenko.task04oop.entity.Quadrangle;

public class FindSpecificationByQuadrangleMoreId extends CompositeSpecification<Quadrangle> {
    private final long minId;

    public FindSpecificationByQuadrangleMoreId(long minId) {
        this.minId = minId;
    }

    @Override
    public boolean isSatisfiedBy(Quadrangle candidate) {
        return candidate.getId() > minId;
    }
}
