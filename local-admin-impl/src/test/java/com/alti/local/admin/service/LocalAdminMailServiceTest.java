package com.alti.local.admin.service;

import java.util.concurrent.Future;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alti.local.admin.dto.TicketDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/spring/localAdmin-applicationContext.xml")
public class LocalAdminMailServiceTest {

	@Autowired
	private LocalAdminMailService localAdminMailService;
	
	private TicketDetails ticketDetails;

	@Before
	public void setUp() {
		
		ticketDetails = new TicketDetails();
		ticketDetails.setUserId("2672");
		ticketDetails.setUserName("Veerraju Y");
		ticketDetails.setUserEmailId("satishjs1019@yahoo.com");
		ticketDetails.setMobileNo("7418511474");
		ticketDetails.setManagerEmailId("satishjs2297@gmail.com");
		ticketDetails.setTicketDescription("Install NodeJs software");
		ticketDetails.setEmpBJ("Need it for POC");
		ticketDetails.setStatus("Inprogress");
	}

	@After
	public void tearDown() {

	}

	@Test 
	public void testSendTicketNotification01() {
		try {
			String[] emailIds = {"satishjs1019@yahoo.com",
					"satishjs2297@gmail.com", "syandagu2297@gmail.com"};
			String msgBody = "Hi Team, \n\n Ticket Has been created, IT Team will get in touch with you to address the issue. \n Thanks IT Support Team ";
			Future<Boolean> mailResult = localAdminMailService.sendTicketNotification(msgBody, emailIds);
			System.out.println("Async call triggered  ");
			Boolean mailStatus = mailResult.get();
			Assert.assertTrue(mailStatus);
			
		 } catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());

		}
	}
	
	@Test @Ignore
	public void testSendTicketNotification02() {
		try {
			localAdminMailService.sendTicketNotification(ticketDetails);
			System.out.println("Async call triggered  ");
		} catch(Exception ex) {
			ex.printStackTrace();
			Assert.fail(ex.getMessage());
		}
	}

}
