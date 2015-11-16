package com.alti.local.admin.security.user;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class ApplicationUser extends User {
	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> userDataMap = new HashMap<String,Object>();
	
	private boolean isAuthencated;

	public ApplicationUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		
	}
	
	public ApplicationUser(String userName, String password,Collection<GrantedAuthority> authorities) {
		this(userName, password, true, true, true, true, authorities);
	}
	
	

	public boolean isAuthencated() {
		return isAuthencated;
	}

	public void setAuthencated(boolean isAuthencated) {
		this.isAuthencated = isAuthencated;
	}

	public Map<String, Object> getUserDataMap() {
		return userDataMap;
	}

	public void setUserDataMap(Map<String, Object> userDataMap) {
		this.userDataMap = userDataMap;
	}



}