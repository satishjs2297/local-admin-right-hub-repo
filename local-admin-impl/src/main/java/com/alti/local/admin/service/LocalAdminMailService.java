/**
 * 
 */
package com.alti.local.admin.service;

import org.springframework.mail.MailException;

import com.alti.local.admin.dto.TicketDetails;



/**
 * @author syandagudita
 *
 */
public interface LocalAdminMailService {

	public void sendTicketNotification(String content,String... emailIdLst) throws MailException;
	
	public void sendTicketNotification(TicketDetails ticketDtls) throws MailException, Exception;
}
