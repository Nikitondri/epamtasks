package by.zakharenko.task04oop.repository.specification.quadrangleregistrar;

import by.zakharenko.task04oop.entity.QuadrangleRegistrar;
import by.zakharenko.task04oop.repository.specification.CompositeSpecification;

public class SpecificationByQuadrangleRegistrarLessPerimeter extends CompositeSpecification<QuadrangleRegistrar> {
    private final double perimeter;

    public SpecificationByQuadrangleRegistrarLessPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean isSatisfiedBy(QuadrangleRegistrar candidate) {
        return candidate.getPerimeter() < perimeter;
    }
}