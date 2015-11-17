/**
 * 
 */
package com.alti.local.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger LOG = LoggerFactory
			.getLogger(LocalAdminAgentController.class);

	@Autowired
	private AuthenticateUserService authUserSrv;

	public LocalAdminAgentController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "addNewUser", method = RequestMethod.POST)
	public String createNewAdminUser(@RequestBody ITAdminUser itAdminUser) {
		LOG.debug("itAdminUser :::: {}", itAdminUser);
		ITAdminUser adminUser = authUserSrv.persistITAdminUser(itAdminUser);
		LOG.debug("itAdminUser :::: {}", itAdminUser);
		return adminUser.getUserId();
	}

	@RequestMapping(value = "getAdminUserLst/{status}", method = RequestMethod.GET)
	public List<ITAdminUser> getITAdminUserList(
			@PathVariable("status") String status) {
		LOG.debug("status ::: {}", status);
		List<ITAdminUser> itAdminUserLst = authUserSrv
				.loadITAdminUserByStatus(status);
		LOG.debug("itAdminUserLst ::: {}", itAdminUserLst);
		return itAdminUserLst;
	}

	@RequestMapping(value = "deleteAdminUser/{userId}", method = RequestMethod.DELETE)
	public String deleteITAdmin(@PathVariable("userId") String userId) {
		LOG.debug("userId ::: {}", userId);
		String dAdminUserId = authUserSrv.deleteITAdminUser(userId);
		LOG.debug("dAdminUserId ::: {}", dAdminUserId);
		return dAdminUserId;
	}

}
