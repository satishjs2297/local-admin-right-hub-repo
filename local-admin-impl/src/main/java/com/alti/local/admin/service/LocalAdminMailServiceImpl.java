/**
 * 
 */
package com.alti.local.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.alti.local.admin.dao.LocalAdminDAO;
import com.alti.local.admin.dao.model.MailContentId;
import com.alti.local.admin.dto.TicketDetails;
import com.alti.local.admin.util.TicketStatus;

/**
 * @author syandagudita
 *
 */
@Service
public class LocalAdminMailServiceImpl implements LocalAdminMailService{
	
	@Autowired
	private MailSender mailSender;
	
	@Value("${IT.ADMIN.EMAILID}")
	private String itAdminEmailId;
	
	@Autowired
	private LocalAdminDAO localAdminDAO;

	@Override
	//@Async
	public void sendTicketNotification(String content, String... emailIdLst)
			throws MailException {
		for(String toEmailId : emailIdLst) {
			if(toEmailId != null) {
				SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
				simpleMailMessage.setSubject("Test Mail");
				simpleMailMessage.setTo(toEmailId);
				simpleMailMessage.setText(content);
				mailSender.send(simpleMailMessage);
			}
		}
	}

	@Override
	public void sendTicketNotification(TicketDetails ticketDtls)
			throws MailException, Exception {
		
		String status = ticketDtls.getStatus();
		
		String emailContent = localAdminDAO.getEmailContent(new MailContentId(ticketDtls.getUserRole(), status));
		
		TicketStatus ticketStatus = null;
		for(TicketStatus ts : TicketStatus.values()) {
			if(ts.toString().equals(status)) {
				ticketStatus = ts;
				break;
			}
		}
		switch(ticketStatus) {
		
			case IN_PROGRESS: {
				//Send Notification to user, manager & IT Admin
				String[] emailIds = {ticketDtls.getUserEmailId(),ticketDtls.getManagerEmailId(),itAdminEmailId};
				sendTicketNotification(emailContent, emailIds);
				break;
			}
			case APPROVED: {
				//Send Notification to user & IT Admin
				String[] emailIds = {ticketDtls.getManagerEmailId(),itAdminEmailId};
				sendTicketNotification(emailContent, emailIds);
				break;
			}
			case DECLINED: {
				//Send Notification to user & IT Admin
				String[] emailIds = {ticketDtls.getManagerEmailId(),itAdminEmailId};
				sendTicketNotification(emailContent, emailIds);
				break;
			}
		}
		
		
	}
	
}
