package by.zakharenko.task04oop.repository.specification.quadrangleregistrar;

import by.zakharenko.task04oop.entity.QuadrangleRegistrar;
import by.zakharenko.task04oop.repository.specification.CompositeSpecification;

public class SpecificationByQuadrangleRegistrarIsConvex extends CompositeSpecification<QuadrangleRegistrar> {
    @Override
    public boolean isSatisfiedBy(QuadrangleRegistrar candidate) {
        return candidate.isConvex();
    }
}
