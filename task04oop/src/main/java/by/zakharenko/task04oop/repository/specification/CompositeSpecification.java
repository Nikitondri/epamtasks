package by.zakharenko.task04oop.repository.specification;

public abstract class CompositeSpecification<T> implements Specification<T> {

    public abstract boolean isSatisfiedBy(T candidate);

    public Specification<T> and(Specification<T> other) {
        return new AndSpecification<>(this, other);
    }

    public Specification<T> or(Specification<T> other) {
        return new OrSpecification<>(this, other);
    }

    public Specification<T> not() {
        return new NotSpecification<>(this);
    }
}