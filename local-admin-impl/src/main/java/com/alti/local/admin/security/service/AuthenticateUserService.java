/**
 * 
 */
package com.alti.local.admin.security.service;

import java.util.List;
import java.util.Map;

import com.alti.local.admin.dao.model.ITAdminUser;

/**
 * @author syandagudita
 *
 */
public interface AuthenticateUserService {
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return map with auth status and status code
	 */
	public Map<String,Object> authenticateUser(String userName,String password);
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public Map<String,Object> getUserDataByName(String userName);
	
	
	public ITAdminUser loadAdminUser(String userName,String password);
	
	
	public ITAdminUser persistITAdminUser(ITAdminUser itAdminUser);
	
	
	public List<ITAdminUser> loadITAdminUserByStatus(String status);	
	
	
	public String deleteITAdminUser(String userId);
	

}
