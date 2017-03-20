package com.podd.WeatherTracker.dao.api;

import java.util.List;

/**
 * Created by ivegotaname on 21.02.17.
 */

    public interface CrudDAO<T> {
        T findById(int id);
        List<T> findAll();
        void create(T t);
        void update(T t);
        void delete(T t);
    }

