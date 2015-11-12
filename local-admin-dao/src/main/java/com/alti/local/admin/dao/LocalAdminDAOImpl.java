/**
 * 
 */
package com.alti.local.admin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alti.local.admin.dao.model.LocalAdminMailContent;
import com.alti.local.admin.dao.model.MailContentId;
import com.alti.local.admin.dao.model.UserTicketDetails;
import com.alti.local.admin.dao.repository.LocalAdminRepository;

/**
 * @author syandagudita
 * 
 */
@Repository
public class LocalAdminDAOImpl implements LocalAdminDAO {

	@PersistenceContext(unitName = "ALTI_DBUNIT")
	private EntityManager eManager;

	@Autowired
	private LocalAdminRepository localAdminRepo;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean saveUserTicketDetails(UserTicketDetails userTckDtls)
			throws Exception {
		return localAdminRepo.save(userTckDtls) != null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updateUserTicketDetails(UserTicketDetails userTckDtls)
			throws Exception {

		return eManager.merge(userTckDtls) != null;
	}

	@Override
	public List<UserTicketDetails> findUserTicketDetailsByStatus(String status) {

		return localAdminRepo.findUserTicketDetailsByStatus(status);
	}

	@Override
	public UserTicketDetails fetchUserTicketDetailsByTicketId(String ticketId) {

		return localAdminRepo.findOne(ticketId);
	}

	@Override
	public String getEmailContent(MailContentId mailContentId) throws Exception {
		LocalAdminMailContent localAdminMailContent = eManager.find(
				LocalAdminMailContent.class, mailContentId);
		String mailContent = localAdminMailContent == null ? ""
				: localAdminMailContent.geteMailContent();
		return mailContent;
	}

}
