/**
 * 
 */
package com.alti.local.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alti.local.admin.dao.LocalAdminDAO;
import com.alti.local.admin.dao.model.UserTicketDetails;
import com.alti.local.admin.dto.TicketDetails;
import com.alti.local.admin.exception.LocalAdminException;
import com.alti.local.admin.util.LocalAdminConstants;
import com.alti.local.admin.util.TicketDetailsUtil;

/**
 * @author syandagudita
 *
 */
@Service
public class LocalAdminServiceImpl implements LocalAdminService {

	private static final Logger LOG = LoggerFactory
			.getLogger(LocalAdminService.class);

	@Autowired
	private LocalAdminDAO localAdminDAO;

	@Autowired
	private LocalAdminMailService eMailService;

	@Override
	public String saveUserTicketDetails(TicketDetails userTckDtls)
			throws LocalAdminException {
		UserTicketDetails userTckDtlsModel = new UserTicketDetails();
		try {

			BeanUtils.copyProperties(userTckDtls, userTckDtlsModel);

			LOG.debug("userTckDtls :: {}, new Object :: {}", userTckDtls,
					userTckDtlsModel);

			// Persist UserTicketDetails
			localAdminDAO.saveUserTicketDetails(userTckDtlsModel);

			// Send eMail to User
			eMailService.sendTicketNotification(userTckDtls);

		} catch (Exception ex) {
			LOG.error("Error @ saveUserTicketDetails :: {}", ex.getMessage());
			throw new LocalAdminException(ex);
		}
		return userTckDtlsModel.getTicketId();
	}

	@Override
	public List<TicketDetails> getUserTicketDetails(String status)
			throws LocalAdminException {
		LOG.debug("status :: {}", status);
		List<UserTicketDetails> ticketDetailsByStatus = localAdminDAO
				.findUserTicketDetailsByStatus(status);
		LOG.debug("ticketDetailsByStatus :: {}", ticketDetailsByStatus);
		List<TicketDetails> tckDtlsLst = new ArrayList<TicketDetails>();
		for (UserTicketDetails userTckDtls : ticketDetailsByStatus) {
			TicketDetails targetTckDtls = TicketDetailsUtil
					.convertToTicketDetails(userTckDtls);
			tckDtlsLst.add(targetTckDtls);
		}
		return tckDtlsLst;
	}

	@Override
	public String updateUserTicketDetails(String userRole, String ticketId,
			String status, String bj) throws LocalAdminException {
		String updateMsg = null;
		try {
			LOG.debug(
					"userRole ::{}, ticketId :: {}, status :: {}, bussiness justification :: {}",
					userRole, ticketId, status, bj);
			UserTicketDetails userTicketDetails = localAdminDAO
					.fetchUserTicketDetailsByTicketId(ticketId);
			
			LOG.debug("userTicketDetails :: {}",userTicketDetails);
			if (userTicketDetails == null)
				return "Data Not Found with TicketId:: " + ticketId;

			if (LocalAdminConstants.EMP_ROLEID.equals(userRole)) {
				userTicketDetails.setEmpBJ(bj);
			} else if (LocalAdminConstants.MANAGER_ROLEID.equals(userRole)) {
				userTicketDetails.setManagerBJ(bj);
			} else if (LocalAdminConstants.ITAGENT_ROLEID.equals(userRole)) {
				userTicketDetails.setAdminBJ(bj);
			}
			userTicketDetails.setStatus(status);
			
			LOG.debug("userTicketDetails :: {}",userTicketDetails);
			boolean updateStatus = localAdminDAO
					.updateUserTicketDetails(userTicketDetails);
			
			LOG.debug("updateStatus :: {}",updateStatus);
			if (updateStatus)
				updateMsg = "Selected Ticket ( " + ticketId
						+ ") has been updated.";

			// Send eMail to User
			eMailService.sendTicketNotification(TicketDetailsUtil
					.convertToTicketDetails(userTicketDetails));

		} catch (Exception ex) {
			LOG.error("Error @ updateUserTicketDetails :: {}",ex.getMessage());
		}
		return updateMsg;
	}

}
