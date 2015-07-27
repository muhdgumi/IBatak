package com.qoantum.springmvc.app.dao.impl;

import com.qoantum.springmvc.app.dao.service.AbstractDaoService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * @author Muhammad Bello Muhammad (muhdgumi@gmail.com)
 * @since 26/07/2015
 */
public abstract class AbstractDaoServiceImpl<K extends Serializable, T> implements AbstractDaoService {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDaoServiceImpl() {
        this.persistentClass = (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T getByKey(Serializable key) {
        return (T) getSession().get(persistentClass, key);
    }

    public void persist(Object entity) {
        getSession().persist(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }

    public Criteria createEntityCriteria() {
        return getSession().createCriteria(persistentClass);
    }
}
