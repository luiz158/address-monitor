package com.address.repo;

import com.address.model.Address;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * User: jules
 * Date: 7/6/14
 */
public class AddressRepoTest extends AbstractRepositoryDaoTest {

    @Autowired @Qualifier("addressRepo")
    private AddressRepository addressRepo;

    @Test
    public void shouldHaveRepo() {
        assertNotNull(addressRepo);
    }

    @Before
    public void setUp() {
      addressRepo.save(of("regis24", "http://www.regis24.de/impressum.php"));
      addressRepo.save(of("savage-wear", "http://www.savage-wear.com/impressum/index.html"));
      addressRepo.save(of("idealo", "http://www.idealo.de/preisvergleich/AGB.html"));
      addressRepo.save(of("moebus-gruppe", "http://www.moebus-gruppe.de/impressum.html"));
    }

    @Test
    public void save(){
        Address address = of("test", "http://test.com");
        addressRepo.save(address);
        assertNotNull(address.getId());
    }

    @Test
    public void findByUrl(){
        Address address = addressRepo.findByUrl("http://www.regis24.de/impressum.php");
        assertThat(address.getCompany(), is("regis24"));
    }

    @Test
    public void findByUrlFail(){
        Address address = addressRepo.findByUrl("aaa");
        assertNull(address);
    }

    @Test
    public void findAll(){
        List<Address> list = addressRepo.getAll();
        assertThat(list.size(), is(4));
    }

    @Test
    public void findById(){
       //TODO
    }


    public static Address of(String company, String url) {
        Address address = new Address();
        address.setCompany(company);
        address.setUrl(url);
        return address;
    }
}
