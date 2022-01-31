package by.zakharenko.task04oop.repository.specification.quadrangleregistrar;

import by.zakharenko.task04oop.entity.QuadrangleRegistrar;
import by.zakharenko.task04oop.repository.specification.CompositeSpecification;

public class SpecificationByQuadrangleRegistrarPerimeter extends CompositeSpecification<QuadrangleRegistrar> {
    private final double perimeter;

    public SpecificationByQuadrangleRegistrarPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean isSatisfiedBy(QuadrangleRegistrar candidate) {
        return candidate.getPerimeter() == perimeter;
    }
}
