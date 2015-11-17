/**
 * 
 */
package com.alti.local.admin.security.service;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthenticateUserService.class);

	@Value("${AUTH_URI}")
	private String authURI;

	@Value("${EMP_DTLS_SVC}")
	private String userDtlsURI;

	@Autowired
	private AdminLoginRepository adminLoginRepo;

	@Override
	public Map<String, Object> authenticateUser(String userName, String password) {
		
		LOG.debug("userName ::{}, password :: {} ",userName,password);
		Map<String, Object> userDataMap = new HashMap<String, Object>();
		try {
			LOG.debug("authURI :: {}",authURI);	
			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(authURI);

			Map<String, String> inputMap = new HashMap<String, String>();
			inputMap.put("user", userName);
			inputMap.put("password", password);

			ResponseEntity<Map> responseEntity = restTemplate.postForEntity(
					uri, inputMap, Map.class);
			if (HttpStatus.OK == responseEntity.getStatusCode()) {
				Map<String, String> authRespMap = responseEntity.getBody();
				LOG.info("response status code :: {}",responseEntity.getStatusCode());
				userDataMap.putAll(authRespMap);
			} else {
				userDataMap.put("authErrMsg", "Auth Service is down");
				LOG.info("Auth Service is down");
			}
			LOG.debug("userDataMap :: {}",userDataMap);
		} catch (Exception ex) {
			LOG.error("Error @ authenticateUser :: {}",ex.getMessage());
		}
		return userDataMap;
	}

	@Override
	public Map<String, Object> getUserDataByName(String userName) {
		Map<String, Object> userDataMap = new HashMap<String, Object>();
		try {
			LOG.debug("userName :: {}",userName);
			RestTemplate restTemplate = new RestTemplate();
			userDtlsURI = userDtlsURI.concat(userName);
			URI uri = new URI(userDtlsURI);
			LOG.debug("userDtlsURI :: {}",userDtlsURI);	
			ResponseEntity<Map> responseEntity = restTemplate.getForEntity(uri,
					Map.class);

			if (HttpStatus.CREATED == responseEntity.getStatusCode()) {
				Map<String, Object> authRespMap = responseEntity.getBody();
				LOG.info("resp status code :: {}",responseEntity.getStatusCode());
				userDataMap.putAll(authRespMap);
			} else {
				LOG.info("Auth Service is down");
			}
			LOG.debug("userDataMap :: {}",userDataMap);
		} catch (Exception ex) {
			LOG.error("Error @ getUserDataByName :: {}",ex.getMessage());
		}
		return userDataMap;
	}

	@Override
	public ITAdminUser loadAdminUser(String userName, String password) {
		LOG.info("userName :: {}, password :: {}",userName,password);
		return adminLoginRepo.findUserByUserIdAndPasswordAndStatus(userName,
				password, "Active");
	}

	@Override
	public ITAdminUser persistITAdminUser(ITAdminUser itAdminUser) {
		LOG.debug("itAdminUser :: {}",itAdminUser);
		ITAdminUser adminUser = adminLoginRepo.save(itAdminUser);
		LOG.info("Saved User :: {}",adminUser);
		return adminUser;
	}

	@Override
	public List<ITAdminUser> loadITAdminUserByStatus(String status) {
		LOG.debug("status ::: {}",status);
		List<ITAdminUser> adminUserLst = adminLoginRepo.findAllByStatus(status);
		LOG.debug("adminUserLst :: {}",adminUserLst);
		return adminUserLst;
	}

	@Override
	public String deleteITAdminUser(String userId) {
		ITAdminUser itAdminUser = adminLoginRepo.findOne(userId);
		LOG.debug("itAdminUser ::{} for userId :: {}",itAdminUser,userId);	
		if (itAdminUser != null) {
			itAdminUser.setStatus("InActive");
			adminLoginRepo.save(itAdminUser);
			LOG.debug("InActive itAdminUser ::{} ",itAdminUser);
			return itAdminUser.getUserId();
		}

		return null;
	}

}
