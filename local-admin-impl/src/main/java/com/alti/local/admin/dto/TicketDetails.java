/**
 * 
 */
package com.alti.local.admin.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author syandagudita
 *
 */
public class TicketDetails extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4848083606671346916L;
	
	/*Machine Details */
	private String pcNo;
	
	private String iPNo;
	
	/* Ticket Details */
	
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

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
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

	@Override
	public String toString() {
		return "TicketDetails [pcNo=" + pcNo + ", iPNo=" + iPNo + ", ticketId="
				+ ticketId + ", ticketCategory=" + ticketCategory
				+ ", ticketDescription=" + ticketDescription + ", status="
				+ status + ", createdBy=" + createdBy + ", modifiedBy="
				+ modifiedBy + ", startDate=" + startDate + ", endDate="
				+ endDate + ", empBJ=" + empBJ + ", managerBJ=" + managerBJ
				+ ", adminBJ=" + adminBJ + "]";
	}

}
