package by.zakharenko.task04oop.repository.specification;

public class AndSpecification<T> extends CompositeSpecification<T>{
    private final Specification<T> left;
    private final Specification<T> right;

    public AndSpecification(Specification<T> newLeft, Specification<T> newRight){
        left = newLeft;
        right = newRight;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return left.isSatisfiedBy(candidate) && right.isSatisfiedBy(candidate);
    }
}
