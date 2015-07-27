package com.qoantum.springmvc.app.dao.service;

import org.hibernate.Criteria;

import java.io.Serializable;

/**
 * A generic class interface that all other DAO class basic operation be inherited by extending the implementation
 * of the interface.
 *
 * @author Muhammad Bello Muhammad (muhdgumi@gmail.com)
 * @since 26/07/2015
 */
public interface AbstractDaoService <K extends Serializable, T> {

    /**
     * The method get the persisted object from the current user session.
     * All operation of getting a entity using the key can be inherited from the base Dao implementation class.
     * @param key
     * @return
     */
    T getByKey(K key);

    /**
     * Data are persisted by taking the submitted entity from the user current session and persist to the
     * provided location through the session factory. It stands as the basic persist(save) operation of
     * all other DAOs.
     * @param entity
     */
    void persist(T entity);

    /**
     * Data are deleted by taking the submitted entity from the user current session and delete it from the
     * session factory. It stands as the basic delete operation of all other DAOs.
     * @param entity
     */
    void delete(T entity);

    /**
     * Provide criteria of the current persistent class.
     * @return
     */
    Criteria createEntityCriteria();
}
