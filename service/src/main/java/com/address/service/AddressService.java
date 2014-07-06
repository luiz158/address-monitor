package com.address.service;

import com.address.model.Address;

import java.util.List;

/**
 * User: jules
 * Date: 7/6/14
 */
public interface AddressService {

    Address saveAddress(Address address, String user);

    List<Address> getAll();
}
