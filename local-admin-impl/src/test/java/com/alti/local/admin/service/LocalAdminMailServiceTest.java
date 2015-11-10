package com.alti.local.admin.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/spring/localAdmin-emailConfig.xml")
public class LocalAdminMailServiceTest {

	@Autowired
	private LocalAdminMailService localAdminMailService;

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {

	}

	@Test
	public void testSendTicketNotification() {
		try {
			String[] emailIds = {"satishjs1019@yahoo.com",
					"satishjs2297@gmail.com", "syandagu2297@gmail.com"};
			String msgBody = "Hi Team, \n\n Ticket Has been created, IT Team will get in touch with you to address the issue. \n Thanks IT Support Team ";
			localAdminMailService.sendTicketNotification(msgBody, emailIds);
			System.out.println("Check Async call  ");
			Thread.sleep(60000);
		 } catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());

		}
	}

}
