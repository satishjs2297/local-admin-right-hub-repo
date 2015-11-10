/**
 * 
 */
package com.alti.local.admin.dao;

import java.util.List;

import com.alti.local.admin.dao.model.MailContentId;
import com.alti.local.admin.dao.model.UserTicketDetails;

/**
 * @author syandagudita
 *
 */
public interface LocalAdminDAO {
	
	public boolean saveUserTicketDetails(UserTicketDetails userTckDtls) throws Exception;
	
	
	public boolean updateUserTicketDetails(UserTicketDetails userTckDtls) throws Exception;
	
	public List<UserTicketDetails> findUserTicketDetailsByStatus(String status);
	
	public UserTicketDetails fetchUserTicketDetailsByTicketId(String ticketId);
	
	
	public String getEmailContent(MailContentId mailContentId) throws Exception;
	
	
	
}
