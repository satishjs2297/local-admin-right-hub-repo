/**
 * 
 */
package com.alti.local.admin.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author syandagudita
 *
 */
@Entity
@Table(name = "USERTICKETDETAILS", catalog = "vigdb")
public class UserTicketDetails extends BaseEntity<String> implements Serializable {

	private String ticketId;
	
	private String ticketCategory;
	
	private String ticketDescription;
	
	private String status;
	
	private String createdBy;
	
	private String modifiedBy;
	
	private Date startDate;
	
	private Date endDate;
	
	private String empBJ;
	
	private String managerBJ;
	
	private String adminBJ;

	

	/*Machine Details */
	private String pcNo;
	
	private String iPNo;
	
	private String userId;
	
	private String userName;
	
	private String userRole;
	
	private String userEmailId;
	
	private String mobileNo;
	
	private String manager;
	
	private String managerEmailId;
	
	private String corpId;
	
	@Id
	@GeneratedValue(generator = "ticketIdGenerator")
	@GenericGenerator(name = "ticketIdGenerator", strategy = "com.alti.local.admin.dao.model.pk.TicketIdGenerator")
	@Column(name = "ticketId")
	public String getTicketId() {
		return ticketId;
	}

	
	public String getTicketCategory() {
		return ticketCategory;
	}

	public void setTicketCategory(String ticketCategory) {
		this.ticketCategory = ticketCategory;
	}

	public String getTicketDescription() {
		return ticketDescription;
	}

	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEmpBJ() {
		return empBJ;
	}

	public void setEmpBJ(String empBJ) {
		this.empBJ = empBJ;
	}

	public String getManagerBJ() {
		return managerBJ;
	}

	public void setManagerBJ(String managerBJ) {
		this.managerBJ = managerBJ;
	}

	public String getAdminBJ() {
		return adminBJ;
	}

	public void setAdminBJ(String adminBJ) {
		this.adminBJ = adminBJ;
	}

	public String getPcNo() {
		return pcNo;
	}

	public void setPcNo(String pcNo) {
		this.pcNo = pcNo;
	}

	public String getiPNo() {
		return iPNo;
	}

	public void setiPNo(String iPNo) {
		this.iPNo = iPNo;
	}

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

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}


	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}


	
}
