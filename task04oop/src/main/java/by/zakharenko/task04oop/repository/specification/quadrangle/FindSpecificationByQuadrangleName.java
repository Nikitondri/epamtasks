package by.zakharenko.task04oop.repository.specification.quadrangle;

import by.zakharenko.task04oop.repository.specification.CompositeSpecification;
import by.zakharenko.task04oop.entity.Quadrangle;


public class FindSpecificationByQuadrangleName extends CompositeSpecification<Quadrangle> {

    private String name;

    public FindSpecificationByQuadrangleName(String newName){
        name = newName;
    }

    @Override
    public boolean isSatisfiedBy(Quadrangle quadrangle) {
        return quadrangle.getName().equalsIgnoreCase(name);
    }
}
