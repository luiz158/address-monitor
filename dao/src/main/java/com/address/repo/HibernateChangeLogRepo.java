package com.address.repo;

import com.address.model.Address;
import com.address.model.ChangeLog;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.address.model.ChangeLog.FIND_BY_ADDRESS;

/**
 * User: jules
 * Date: 7/6/14
 */
@Repository("changeLogRepo")
public class HibernateChangeLogRepo extends HibernateAbstractRepo<ChangeLog> implements ChangeLogRepository {

    /**
     * Creates a new Hibernate account manager.
     *
     * @param sessionFactory the Hibernate session factory
     */
    @Autowired
    public HibernateChangeLogRepo(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ChangeLog> findByAddress(Address address) {
        return (List<ChangeLog>) getCurrentSession().getNamedQuery(FIND_BY_ADDRESS)
                .setParameter("addressId", address.getId()).list();
    }
}
