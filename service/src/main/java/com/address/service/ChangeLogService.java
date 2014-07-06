package com.address.service;

import com.address.model.Address;
import com.address.model.ChangeLog;

import java.util.List;

/**
 * User: jules
 * Date: 7/6/14
 */
public interface ChangeLogService {

    List<ChangeLog> getAllForAddress(Address address);

    void addLog(Address address, String user);
}
