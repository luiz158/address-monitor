package com.address.service;

import com.address.model.Address;
import com.address.model.ChangeLog;
import com.address.repo.AddressRepoTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * User: jules
 * Date: 7/6/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring/app-service-config.xml",
        "classpath:spring/test-db-config.xml"})
@Transactional
public class AddressServiceImplTest {

    Logger logger = LoggerFactory.getLogger("com.address");

    @Autowired
    AddressService addressService;

    @Autowired
    ChangeLogService changeLogService;

    @Test
    public void shouldHaveService() {
        assertNotNull(addressService);
    }

    @Test
    public void saveAddress() {
        Address address = AddressRepoTest.of("regis24", "http://www.regis24.de/impressum.php");
        addressService.saveAddress(address, "test1");

        List<Address> list = addressService.getAll();
        assertThat(list.size(), is(1));

        List<ChangeLog> logs = changeLogService.getAllForAddress(address);
        assertThat(logs.size(), is(1));

        address.setUrl("http://www.regis24.de/test2.php");
        addressService.saveAddress(address, "test2");

        logs = changeLogService.getAllForAddress(address);
        assertThat(logs.size(), is(2));
        assertThat(logs.get(1).getUser(), is("test2"));
        assertThat(logs.get(1).getUrl(), is("http://www.regis24.de/test2.php"));
        logger.info("Test results: " + logs.toString());
    }

}
