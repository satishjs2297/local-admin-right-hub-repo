/**
 * 
 */
package com.alti.local.admin.security.service;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alti.local.admin.dao.model.ITAdminUser;
import com.alti.local.admin.dao.repository.AdminLoginRepository;

/**
 * @author syandagudita
 *
 */
@Service
public class AuthenticateUserServiceImpl implements AuthenticateUserService {

	@Value("${AUTH_URI}")
	private String authURI;

	@Value("${EMP_DTLS_SVC}")
	private String userDtlsURI;

	@Autowired
	private AdminLoginRepository adminLoginRepo;

	@Override
	public Map<String, Object> authenticateUser(String userName, String password) {
		Map<String, Object> userDataMap = new HashMap<String, Object>();
		try {
			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(authURI);

			Map<String, String> inputMap = new HashMap<String, String>();
			inputMap.put("user", userName);
			inputMap.put("password", password);

			ResponseEntity<Map> responseEntity = restTemplate.postForEntity(
					uri, inputMap, Map.class);
			if (HttpStatus.OK == responseEntity.getStatusCode()) {
				Map<String, String> authRespMap = responseEntity.getBody();
				System.out.println("authResp::: " + authRespMap);
				userDataMap.putAll(authRespMap);
			} else {
				userDataMap.put("authErrMsg", "Auth Service is down");
				System.out.println("Auth Service is down");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return userDataMap;
	}

	@Override
	public Map<String, Object> getUserDataByName(String userName) {
		Map<String, Object> userDataMap = new HashMap<String, Object>();
		try {
			RestTemplate restTemplate = new RestTemplate();
			userDtlsURI = userDtlsURI.concat(userName);
			URI uri = new URI(userDtlsURI);

			ResponseEntity<Map> responseEntity = restTemplate.getForEntity(uri,
					Map.class);

			if (HttpStatus.CREATED == responseEntity.getStatusCode()) {
				Map<String, Object> authRespMap = responseEntity.getBody();
				System.out.println("authResp::: " + authRespMap);
				userDataMap.putAll(authRespMap);
			} else {
				System.out.println("Auth Service is down");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return userDataMap;
	}

	@Override
	public ITAdminUser loadAdminUser(String userName, String password) {

		return adminLoginRepo.findUserByUserIdAndPasswordAndStatus(userName,
				password, "Active");
	}

	@Override
	public ITAdminUser persistITAdminUser(ITAdminUser itAdminUser) {

		ITAdminUser adminUser = adminLoginRepo.save(itAdminUser);

		return adminUser;
	}

	@Override
	public List<ITAdminUser> loadITAdminUserByStatus(String status) {
		List<ITAdminUser> adminUserLst = adminLoginRepo.findAllByStatus(status);
		return adminUserLst;
	}

	@Override
	public String deleteITAdminUser(String userId) {
		ITAdminUser itAdminUser = adminLoginRepo.findOne(userId);
		if (itAdminUser != null) {
			itAdminUser.setStatus("InActive");
			adminLoginRepo.save(itAdminUser);
			return itAdminUser.getUserId();
		}

		return null;
	}

}
