package by.zakharenko.task04oop.repository.specification.quadrangle;

import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.entity.QuadrangleRegistrar;
import by.zakharenko.task04oop.repository.QuadrangleRegistrarRepository;
import by.zakharenko.task04oop.repository.specification.CompositeSpecification;

public class FindSpecificationByQuadrangleArea extends CompositeSpecification<Quadrangle> {
    private final double area;

    public FindSpecificationByQuadrangleArea(double area) {
        this.area = area;
    }

    @Override
    public boolean isSatisfiedBy(Quadrangle candidate) {
        QuadrangleRegistrar registrar = QuadrangleRegistrarRepository.getInstance().get(candidate.getId());
        return registrar.getArea() == area;
    }
}
