package com.address.repo;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: jules
 * Date: 7/6/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/app-dao-config.xml", "classpath:spring/test-db-config.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AbstractRepositoryDaoTestCase {

}
