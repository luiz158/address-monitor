package com.address.repo;

import com.address.model.Address;
import com.address.model.ChangeLog;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * User: jules
 * Date: 7/6/14
 */
public class ChangeLogTest extends AbstractRepositoryDaoTestCase {
    @Autowired @Qualifier("changeLogRepo")
    private ChangeLogRepository changeLogRepo;

    @Autowired @Qualifier("addressRepo")
    private AddressRepository addressRepo;

    private Address address;

    @Test
    public void shouldHaveRepo() {
        assertNotNull(changeLogRepo);
        assertNotNull(addressRepo);
    }

    @Before
    public void setUp(){
        address = addressRepo.save(AddressRepoTest.of("regis24", "http://www.regis24.de/impressum.php"));
        assertNotNull(address.getId());

        changeLogRepo.save(of(address, "test", "http://www.regis24.de/impressum.php"));
        changeLogRepo.save(of(address, "test1", "http://www.regis24.de/test1.php"));
        //this is last modification on the address registered in the change_log table
        changeLogRepo.save(of(address, "test2", "http://www.regis24.de/test2.php"));
    }

    @Test
    public void findByAddress(){
        List<ChangeLog> list = changeLogRepo.findByAddress(address);
        assertThat(list.size(), is(3));
        assertThat(list.get(2).getUser(), is("test2"));
    }

    public static ChangeLog of(Address address, String user, String url){
        ChangeLog changeLog = new ChangeLog();
        changeLog.setUrl(url);
        changeLog.setUser(user);
        changeLog.setAddress(address);
        return changeLog;
    }
}
