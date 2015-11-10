package com.alti.local.admin.service;

import java.util.List;

import com.alti.local.admin.dto.TicketDetails;
import com.alti.local.admin.exception.LocalAdminException;


/**
 * 
 * @author syandagudita
 *
 */
public interface LocalAdminService {

	/**
	 * 
	 * @param userTckDtls
	 * @return
	 * @throws LocalAdminException
	 */
	public String saveUserTicketDetails(TicketDetails userTckDtls) throws LocalAdminException;
	
	/**
	 * 
	 * @param status
	 * @return
	 * @throws LocalAdminException
	 */
	public List<TicketDetails> getUserTicketDetails(String status) throws LocalAdminException;
	
	/**
	 * 
	 * @param ticketId
	 * @param status
	 * @param bj (Business Justification)
	 * @return
	 * @throws LocalAdminException
	 */
	public String updateUserTicketDetails(String userRole,String ticketId,String status,String bj) throws LocalAdminException;
}
