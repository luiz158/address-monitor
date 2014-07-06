package com.address.repo;

import com.address.model.Address;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.address.model.Address.*;

/**
 * User: jules
 * Date: 7/6/14
 */
@Repository("addressRepo")
public class HibernateAddressRepo extends HibernateAbstractRepo<Address> implements AddressRepository {

    /**
     * Creates a new Hibernate account manager.
     *
     * @param sessionFactory the Hibernate session factory
     */
    @Autowired
    public HibernateAddressRepo(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Address findById(Long id) {
        return (Address) getCurrentSession().getNamedQuery(FIND_BY_ID).setParameter("id", id).uniqueResult();
    }

    @Override
    public Address findByUrl(String url) {
        return (Address) getCurrentSession().getNamedQuery(FIND_BY_URL).setParameter("url", url).uniqueResult();
    }

    @Override
    public List<Address> getAll() {
        return (List<Address>) getCurrentSession().getNamedQuery(FIND_ALL).list();
    }
}
