/**
 * 
 */
package com.alti.local.admin.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alti.local.admin.dto.TicketDetails;
import com.alti.local.admin.util.TicketStatus;

/**
 * @author syandagudita
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/spring/localAdmin-applicationContext.xml")
public class LocalAdminServiceTest {

	@Autowired
	private LocalAdminService localAdminService;
	
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
	public void testSaveUserTicketDetails() {
		String ticketId = localAdminService.saveUserTicketDetails(ticketDetails);
		Assert.assertNotNull(ticketId);
		
	}
	
}
