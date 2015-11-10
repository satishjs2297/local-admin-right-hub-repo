package com.alti.local.admin.util;

public enum TicketStatus {
	
	IN_PROGRESS("Inprogress"),APPROVED("Approved"),DECLINED("Declined");
	
	private String status;
	private TicketStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return status;
	}
	
}
