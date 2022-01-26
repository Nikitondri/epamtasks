package by.zakharenko.task04oop.repository.specification.quadrangle;

import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.entity.QuadrangleRegistrar;
import by.zakharenko.task04oop.repository.QuadrangleRegistrarRepository;
import by.zakharenko.task04oop.repository.specification.CompositeSpecification;

public class FindSpecificationByQuadrangleQuarter extends CompositeSpecification<QuadrangleRegistrar> {
    private final Integer quarter;

    public FindSpecificationByQuadrangleQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    @Override
    public boolean isSatisfiedBy(QuadrangleRegistrar candidate) {
        QuadrangleRegistrar registrar = QuadrangleRegistrarRepository.getInstance().get(candidate.getId());
        return registrar.getQuarters().contains(quarter);
    }
}
