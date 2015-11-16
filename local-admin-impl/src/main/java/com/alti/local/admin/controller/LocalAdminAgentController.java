/**
 * 
 */
package com.alti.local.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alti.local.admin.dao.model.ITAdminUser;
import com.alti.local.admin.security.service.AuthenticateUserService;

/**
 * @author syandagudita
 *
 */
@RestController
@RequestMapping("/ladmin-agent")
public class LocalAdminAgentController extends AbstractLocalAdminController {
	
	@Autowired
	private AuthenticateUserService authUserSrv;
	
	public LocalAdminAgentController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "addNewUser", method = RequestMethod.POST)
	public String createNewAdminUser(@RequestBody ITAdminUser itAdminUser) {
		
		ITAdminUser adminUser = authUserSrv.persistITAdminUser(itAdminUser);
		
		return adminUser.getUserId(); 
	}
	
	
	@RequestMapping(value = "getAdminUserLst/{status}", method = RequestMethod.GET)
	public List<ITAdminUser> getITAdminUserList(@PathVariable("status") String status) {
		List<ITAdminUser> itAdminUserLst = authUserSrv.loadITAdminUserByStatus(status);
		return itAdminUserLst;
	}
	
	@RequestMapping(value = "deleteAdminUser/{userId}", method = RequestMethod.DELETE)
	public String deleteITAdmin(@PathVariable("userId") String userId) {
		String dAdminUserId = authUserSrv.deleteITAdminUser(userId);
		return dAdminUserId;
	}
	
	
	
	
	
	
}
