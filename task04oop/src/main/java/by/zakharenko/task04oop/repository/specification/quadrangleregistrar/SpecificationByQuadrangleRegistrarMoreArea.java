package by.zakharenko.task04oop.repository.specification.quadrangleregistrar;

import by.zakharenko.task04oop.entity.QuadrangleRegistrar;
import by.zakharenko.task04oop.repository.specification.CompositeSpecification;

public class SpecificationByQuadrangleRegistrarMoreArea extends CompositeSpecification<QuadrangleRegistrar> {
    private final double area;

    public SpecificationByQuadrangleRegistrarMoreArea(double area) {
        this.area = area;
    }

    @Override
    public boolean isSatisfiedBy(QuadrangleRegistrar candidate) {
        return candidate.getArea() > area;
    }
}
