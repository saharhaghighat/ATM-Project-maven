package com.none.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional <T> findById (Integer Id);

    List<T> getAll();
     void save(T t);
     void update(Integer id,T t);
     void delete (T t);



}
