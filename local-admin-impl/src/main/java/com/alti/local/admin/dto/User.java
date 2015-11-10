package com.alti.local.admin.dto;

import java.io.Serializable;

public class User implements Serializable{
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	/* User */
	private String userId;
	
	private String userName;
	
	private String userRole;
	
	private String userEmailId;
	
	private String mobileNo;
	
	private String manager;
	
	private String managerEmailId;
	
	private String corpId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getManagerEmailId() {
		return managerEmailId;
	}

	public void setManagerEmailId(String managerEmailId) {
		this.managerEmailId = managerEmailId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userRole=" + userRole + ", userEmailId=" + userEmailId
				+ ", mobileNo=" + mobileNo + ", manager=" + manager
				+ ", managerEmailId=" + managerEmailId + ", corpId=" + corpId
				+ "]";
	}

	
}
