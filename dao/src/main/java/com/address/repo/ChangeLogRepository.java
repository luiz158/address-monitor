package com.address.repo;

import com.address.model.Address;
import com.address.model.ChangeLog;

import java.util.List;

/**
 * User: jules
 * Date: 7/6/14
 */
public interface ChangeLogRepository extends AbstractRepository<ChangeLog> {

    List<ChangeLog> findByAddress(Address address);
}
