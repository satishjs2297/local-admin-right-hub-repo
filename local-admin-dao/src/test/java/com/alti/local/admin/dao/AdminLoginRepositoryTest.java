package com.alti.local.admin.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alti.local.admin.dao.model.ITAdminUser;
import com.alti.local.admin.dao.repository.AdminLoginRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/localAdmin-daoJpaConfig.xml","classpath:localAdmin-daoJpaConfig-test.xml"})
public class AdminLoginRepositoryTest {

	@Autowired
	private AdminLoginRepository adminLoginRepo;
	
	@Before
	public void setUP() {
		
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void testITAdminLoginUser() {
		System.out.println("adminLoginRepo ::: "+adminLoginRepo);
		ITAdminUser iTAdminUser = adminLoginRepo.findUserByUserIdAndPasswordAndStatus("veerraju", "amma2297","Active");
		System.out.println(">>>>>>>>> "+iTAdminUser);
	}
	
	@Test
	public void testUpdateITAdminLoginUser() {
		System.out.println(">>>>>>>>>>>>>>>>Bein>>>>>>>>>>>>");
		ITAdminUser adminUser = adminLoginRepo.findOne("2297");
		adminUser.setStatus("InActive");
		ITAdminUser itAdminUser = adminLoginRepo.save(adminUser);
		System.out.println(itAdminUser);
		
	}
	
	@Test
	public void testFindAllByStatus() {
		System.out.println(">>>>>>>>>>>>Begin>>>>>>>>>>>.");
		List<ITAdminUser> findAllByStatus = adminLoginRepo.findAllByStatus("Active");
		System.out.println("findAllUser ::"+ findAllByStatus);
	}
	
}
