package com.sagarandcompany.HibernateCrud.repository.common;

public interface BaseRepository {
    Object get(Long id);

    Object Load(Long id);

    Object save(Object object);

    void delete(Object object);

    void flush();

}

