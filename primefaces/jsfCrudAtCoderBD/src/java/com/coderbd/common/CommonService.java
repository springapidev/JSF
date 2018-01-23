/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.common;


import com.coderbd.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javassist.bytecode.SignatureAttribute.TypeVariable;
import javax.transaction.Transactional;

/**
 *
 * @author Rajaul Islam
 * @param <E>
 */
public class CommonService<E> implements CommonDao<E> {

    SessionFactory sessFact = HibernateUtil.getSessionFactory();
    Session session = sessFact.openSession();
    org.hibernate.Transaction tr = session.beginTransaction();

    protected E instance;
    private Class<E> entityClass;

    @Override
    public void persist(E e) throws Exception {
        getSession().persist(e);
        tr.commit();
        getSession().close();
    }

    @Override
    @Transactional
    public void merge(E e) throws Exception {
        getSession().merge(e);
        tr.commit();
        getSession().close();
    }

    @Override
    @Transactional
    public void remove(Object id) throws Exception {
        getSession().remove((E) getSession().find(getEntityClass(), id));
        tr.commit();
        getSession().close();
    }

    @Override
    @Transactional
    public E findById(Object id) throws Exception {
        return (E) getSession().find(getEntityClass(), id);

    }

    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        return getSession().createQuery("Select t from " + getEntityClass().getSimpleName() + " t").getResultList();
    }

    @Override
    @Transactional
    public List<E> findByProperty(String prop, Object val) throws Exception {
        return (List<E>) getSession().createQuery("select x from " + getEntityClass().getSimpleName() + " x where x." + prop + " = ?1").setParameter(1, val).getResultList();
    }

    @Override
    @Transactional
    public List<E> findInRange(int firstResult, int maxResults) throws Exception {
        return getSession().createQuery("Select t from " + getEntityClass().getSimpleName() + " t").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    @Transactional
    public long count() throws Exception {
        return (Long) getSession().createQuery("Select count(t) from " + getEntityClass().getSimpleName() + " t").getSingleResult();
    }

    public Session getSession() {
        if(session == null){
        session = sessFact.openSession();
        }
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @SuppressWarnings("unchecked")
    public Class<E> getEntityClass() throws Exception {
        if (entityClass == null) {
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                ParameterizedType paramType = (ParameterizedType) type;
                if (paramType.getActualTypeArguments().length == 2) {
                    if (paramType.getActualTypeArguments()[1] instanceof TypeVariable) {
                        throw new IllegalArgumentException(
                                "Can't find class using reflection");
                    } else {
                        entityClass = (Class<E>) paramType.getActualTypeArguments()[1];
                    }
                } else {
                    entityClass = (Class<E>) paramType.getActualTypeArguments()[0];
                }
            } else {
                throw new Exception("Can't find class using reflection");
            }
        }
        return entityClass;
    }

}
