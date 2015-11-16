package com.alti.local.admin.service;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.alti.local.admin.security.service.AuthenticateUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/config/spring/localAdmin-applicationContext.xml" })
public class AuthenticateUserServiceTest {

	@Autowired
	private AuthenticateUserService authenticateUserService;

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {

	}

	@Test
	public void testRestAuthService() {

		String userName = "syandagudita";
		String password = "2297$VigMani";
		Map<String, Object> userDataMap = authenticateUserService
				.authenticateUser(userName, password);
		Assert.notNull(userDataMap);
	}
	
	@Test
	public void testRestUserDtlsService() {
		String userName = "Vnagamanickam";
		Map<String, Object> userDataByName = authenticateUserService.getUserDataByName(userName);
		Assert.notNull(userDataByName);
	}

}
