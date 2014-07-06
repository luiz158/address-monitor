package com.address.repo;

import com.address.model.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * User: jules
 * Date: 7/6/14
 */
public class HibernateAbstractRepo<Type extends BaseEntity> implements AbstractRepository<Type> {

    protected SessionFactory sessionFactory;

    @Override
    public Type saveOrUpdate(Type entity) {
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public Type save(Type entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public Type update(Type entity) {
        getCurrentSession().update(entity);
        return entity;
    }

    @Override
    public void delete(Type entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteById(Long id, Type entity) {
        getCurrentSession().delete(id.toString(), entity.getClass());
    }

    /**
     * Returns the session associated with the ongoing transaction.
     *
     * @return the current session
     */
    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
