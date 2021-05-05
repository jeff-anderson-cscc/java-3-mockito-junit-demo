package edu.cscc.degrees.data;

import java.util.List;
import java.util.Optional;

public interface CrudRepository <T, K> {
  Optional<T> findById(K primaryKey);
  List<T> findAll();
  T create(T entity);
  void update(T entity);
  void delete(K primaryKey);
}