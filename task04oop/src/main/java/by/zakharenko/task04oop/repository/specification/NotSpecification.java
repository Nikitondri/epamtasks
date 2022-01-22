package by.zakharenko.task04oop.repository.specification;

public class NotSpecification<T> extends CompositeSpecification<T> {
    private Specification<T> other;

    public NotSpecification(Specification<T> newOther){
        other = newOther;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return !other.isSatisfiedBy(candidate);
    }
}
