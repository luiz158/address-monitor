package com.address.repo;

import com.address.model.Address;

import java.util.List;

/**
 * User: jules
 * Date: 7/6/14
 */
public interface AddressRepository extends AbstractRepository<Address> {

    Address findById(Long id);

    Address findByUrl(String url);

    List<Address> getAll();

}
