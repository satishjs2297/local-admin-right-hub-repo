/**
 * 
 */
package com.alti.local.admin.service;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
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
public class LocalAdminMailServiceImpl implements LocalAdminMailService {

	private static final Logger LOG = LoggerFactory
			.getLogger(LocalAdminMailService.class);

	@Autowired
	private MailSender mailSender;

	@Value("${IT.ADMIN.EMAILID}")
	private String itAdminEmailId;

	@Autowired
	private LocalAdminDAO localAdminDAO;

	@Override
	public Future<Boolean> sendTicketNotification(String content,
			String... emailIdLst) throws MailException {
		LOG.debug("emailIdLst :: {}", emailIdLst);
		for (String toEmailId : emailIdLst) {
			if (toEmailId != null) {
				try {
					SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
					simpleMailMessage.setSubject("Test Mail");
					simpleMailMessage.setTo(toEmailId);
					simpleMailMessage.setText(content);
					mailSender.send(simpleMailMessage);
				} catch (MailException ex) {
					// log mail exception
					LOG.error("Error @ sendTicketNotification :: {}",
							ex.getMessage());
				}
			}
		}
		return new AsyncResult<Boolean>(true);
	}

	@Async
	@Override
	public void sendTicketNotification(TicketDetails ticketDtls)
			throws MailException, Exception {

		LOG.debug("ticketDtls :: {}", ticketDtls);
		String status = ticketDtls.getStatus();

		String emailContent = localAdminDAO.getEmailContent(new MailContentId(
				ticketDtls.getUserRole(), status));

		LOG.debug("emailContent :: {}", emailContent);
		TicketStatus ticketStatus = null;
		for (TicketStatus ts : TicketStatus.values()) {
			if (ts.toString().equals(status)) {
				ticketStatus = ts;
				break;
			}
		}

		LOG.info("ticketStatus :: {}, itAdminEmailId :: {} ", ticketStatus,
				itAdminEmailId);
		switch (ticketStatus) {

		case IN_PROGRESS: {
			// Send Notification to user, manager & IT Admin
			String[] emailIds = { ticketDtls.getUserEmailId(),
					ticketDtls.getManagerEmailId(), itAdminEmailId };
			sendTicketNotification(emailContent, emailIds);
			break;
		}
		case APPROVED: {
			// Send Notification to user & IT Admin
			String[] emailIds = { ticketDtls.getManagerEmailId(),
					itAdminEmailId };
			sendTicketNotification(emailContent, emailIds);
			break;
		}
		case DECLINED: {
			// Send Notification to user & IT Admin
			String[] emailIds = { ticketDtls.getManagerEmailId(),
					itAdminEmailId };
			sendTicketNotification(emailContent, emailIds);
			break;
		}
		}

	}

}
