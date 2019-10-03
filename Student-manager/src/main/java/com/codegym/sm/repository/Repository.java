package com.codegym.sm.repository;

import java.util.List;

public interface Repository<T> {
    List<T>findAll();
    T findById(Long id);
    void save(T student);
    void remove(Long id);
}
