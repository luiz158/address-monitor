package com.address.service;

import com.address.model.Address;
import com.address.model.ChangeLog;
import com.address.repo.ChangeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * User: jules
 * Date: 7/6/14
 */
@Service("changeLogService")
public class ChangeLogServiceImpl implements ChangeLogService {

    @Autowired @Qualifier("changeLogRepo")
    private ChangeLogRepository changeLogRepo;


    @Override
    public List<ChangeLog> getAllForAddress(Address address) {
        return changeLogRepo.findByAddress(address);
    }

    @Override
    @Transactional
    public void addLog(Address address, String user) {
        ChangeLog changeLog = new ChangeLog();
        changeLog.setAddress(address);
        changeLog.setUrl(address.getUrl());
        changeLog.setUser(user);
        changeLogRepo.save(changeLog);
    }

    public void setChangeLogRepo(ChangeLogRepository changeLogRepo) {
        this.changeLogRepo = changeLogRepo;
    }
}
