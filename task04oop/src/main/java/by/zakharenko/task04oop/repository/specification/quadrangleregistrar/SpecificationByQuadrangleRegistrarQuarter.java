package by.zakharenko.task04oop.repository.specification.quadrangleregistrar;

import by.zakharenko.task04oop.entity.QuadrangleRegistrar;
import by.zakharenko.task04oop.repository.specification.CompositeSpecification;

public class SpecificationByQuadrangleRegistrarQuarter extends CompositeSpecification<QuadrangleRegistrar> {
    private final Integer quarter;

    public SpecificationByQuadrangleRegistrarQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    @Override
    public boolean isSatisfiedBy(QuadrangleRegistrar candidate) {
        return candidate.getQuarters().contains(quarter);
    }
}
