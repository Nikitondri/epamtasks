package by.zakharenko.cafe.dao;

import by.zakharenko.cafe.dao.exception.DaoException;
import by.zakharenko.cafe.entity.CafeEntity;

import java.util.List;
import java.util.Optional;

public interface Dao<T extends CafeEntity> {
    List<T> findAll() throws DaoException;
    Optional<T> getById(long id) throws DaoException;
    void insert(T item) throws DaoException;
    void removeById(long id) throws DaoException;
    int getNumRows() throws DaoException;
}
