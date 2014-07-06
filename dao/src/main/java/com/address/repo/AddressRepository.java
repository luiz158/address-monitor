package com.address.repo;

import com.address.model.Address;

/**
 * User: jules
 * Date: 7/6/14
 */
public interface AddressRepository {

    Address findById(Long id);

    Address findByUrl(String url);

}
