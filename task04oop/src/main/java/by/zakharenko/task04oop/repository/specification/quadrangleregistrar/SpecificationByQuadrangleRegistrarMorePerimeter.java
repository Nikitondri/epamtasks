package by.zakharenko.task04oop.repository.specification.quadrangleregistrar;

import by.zakharenko.task04oop.entity.QuadrangleRegistrar;
import by.zakharenko.task04oop.repository.specification.CompositeSpecification;

public class SpecificationByQuadrangleRegistrarMorePerimeter extends CompositeSpecification<QuadrangleRegistrar> {
    private final double perimeter;

    public SpecificationByQuadrangleRegistrarMorePerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean isSatisfiedBy(QuadrangleRegistrar candidate) {
        return candidate.getPerimeter() > perimeter;
    }
}
