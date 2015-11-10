package com.alti.local.admin.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alti.local.admin.dao.model.UserTicketDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/config/spring/localAdmin-daoJpaConfig.xml" })
public class LocalAdminDAOTest {

	@Autowired
	private LocalAdminDAO localAdminDAO;
	
	private UserTicketDetails userTicketDtls;

	@Before
	public void setUp() {
		userTicketDtls = new UserTicketDetails();
		userTicketDtls
				.setTicketDescription("Install WebStom IDE and activiate it for 1 years");
		userTicketDtls.setTicketCategory("New Software");
		userTicketDtls.setUserId("2766");
		userTicketDtls.setUserName("Veerraju Yandagudita");
		userTicketDtls.setMobileNo("9866744203");
		userTicketDtls.setStatus("inprogress");
	}

	@After
	public void tearDown() {

	}

	@Test @Ignore
	public void testSaveUserTicketDetails() {
		try {
			
			localAdminDAO.saveUserTicketDetails(userTicketDtls);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Test 
	public void testFindUserTicketDetails() {
		List<UserTicketDetails> userTicketDtls = localAdminDAO.findUserTicketDetailsByStatus("inprogress");
		Assert.assertNotNull(userTicketDtls);
		System.out.println("userTicketDtls ::: "+userTicketDtls);
	}
	
	

}
