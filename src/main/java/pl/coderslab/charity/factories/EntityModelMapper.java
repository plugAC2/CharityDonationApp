package pl.coderslab.charity.factories;

public interface EntityModelMapper<T, M> {
    T createEntityFromModel(M m);
    M createModelFromEntity(T t);
}
