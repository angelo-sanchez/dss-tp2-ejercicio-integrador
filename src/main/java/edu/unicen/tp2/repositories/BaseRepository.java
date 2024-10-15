package edu.unicen.tp2.repositories;

import java.util.List;

public interface BaseRepository<T, I> {
    T save(T entity);
    T findById(I id);
    void delete(T entity);
    List<T> findAll();
}
