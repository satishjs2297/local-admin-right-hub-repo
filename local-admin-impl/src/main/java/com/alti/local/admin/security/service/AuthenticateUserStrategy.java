/**
 * 
 */
package com.alti.local.admin.security.service;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.alti.local.admin.dao.model.ITAdminUser;
import com.alti.local.admin.security.user.ApplicationUser;

/**
 * @author syandagudita
 *
 */
@Component
public class AuthenticateUserStrategy {

	private static final Logger LOG = LoggerFactory
			.getLogger(AuthenticateUserStrategy.class);

	private AuthenticateUserService authUserService;

	public AuthenticateUserStrategy() {
		// TODO Auto-generated constructor stub
	}

	public ApplicationUser invokeAuthService(String userName, String password,
			Collection<GrantedAuthority> grantedAuthorities) {

		LOG.debug("userName :: {}, password :: {}", userName, password);
		ApplicationUser appUser = new ApplicationUser(userName, password,
				grantedAuthorities);

		// Invoke authUserService and build ApplicationUser
		Map<String, Object> userDataMap = authUserService.authenticateUser(
				userName, password);
		LOG.debug("userDataMap :: {}", userDataMap);
		Integer statusCode = (Integer) userDataMap.get("errorCode") == null ? 0
				: (Integer) userDataMap.get("errorCode");

		if (200 == statusCode) {
			LOG.info("Rest Auth Service Successed");
			appUser.setAuthencated(true);
			userDataMap.putAll(authUserService.getUserDataByName(userName));
			appUser.setUserDataMap(userDataMap);

		} else {
			// Invoke admin login.
			ITAdminUser loadAdminUser = authUserService.loadAdminUser(userName,
					password);
			LOG.info("ITAdminUser :: {}", loadAdminUser);
			if (loadAdminUser != null) {
				appUser.setAuthencated(true);
				userDataMap.put("userName", userName);
				userDataMap.put("roleId", loadAdminUser.getRoleId());
				appUser.setUserDataMap(userDataMap);
			} else {
				LOG.info("Authentication Failed:: Please re-check your userName & Password");
				appUser.setAuthencated(false);
			}
		}

		return appUser;
	}

	public void setAuthUserService(AuthenticateUserService authUserService) {
		this.authUserService = authUserService;
	}

}
