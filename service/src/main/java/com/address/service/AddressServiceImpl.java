package com.address.service;

import com.address.model.Address;
import com.address.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * User: jules
 * Date: 7/6/14
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired @Qualifier("addressRepo")
    private AddressRepository addressRepo;

    public List<Address> getAll(){
        return addressRepo.getAll();
    }

    @Transactional
    public Address saveAddress(Address address, String user){
        return addressRepo.saveOrUpdate(address);
    }

    public void setAddressRepo(AddressRepository addressRepo) {
        this.addressRepo = addressRepo;
    }
}
