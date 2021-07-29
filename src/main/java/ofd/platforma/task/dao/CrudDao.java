package ofd.platforma.task.dao;

import java.util.List;

public interface CrudDao<T, PK> {

    T save(T entity);

    T findById(PK id);

    List<T> findAll();
}
