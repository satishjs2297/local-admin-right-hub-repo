/**
 * 
 */
package com.alti.local.admin.service;

import java.util.ArrayList;
import java.util.List;

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

			// Persist UserTicketDetails
			localAdminDAO.saveUserTicketDetails(userTckDtlsModel);

			// Send eMail to User
			eMailService.sendTicketNotification(userTckDtls);

		} catch (Exception ex) {
			// log exception
			throw new LocalAdminException(ex);
		}
		return userTckDtlsModel.getTicketId();
	}

	@Override
	public List<TicketDetails> getUserTicketDetails(String status)
			throws LocalAdminException {
		List<UserTicketDetails> ticketDetailsByStatus = localAdminDAO
				.findUserTicketDetailsByStatus(status);
		List<TicketDetails> tckDtlsLst = new ArrayList<TicketDetails>();
		for (UserTicketDetails userTckDtls : ticketDetailsByStatus) {
			TicketDetails targetTckDtls = TicketDetailsUtil.convertToTicketDetails(userTckDtls);
			tckDtlsLst.add(targetTckDtls);
		}
		return tckDtlsLst;
	}

	@Override
	public String updateUserTicketDetails(String userRole, String ticketId,
			String status, String bj) throws LocalAdminException {
		String updateMsg = null;
		try {
			UserTicketDetails userTicketDetails = localAdminDAO
					.fetchUserTicketDetailsByTicketId(ticketId);
			
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
			boolean updateStatus = localAdminDAO.updateUserTicketDetails(userTicketDetails);
			if(updateStatus)
				updateMsg = "Selected Ticket ( "+ ticketId + ") has been updated.";
			
			// Send eMail to User
			eMailService.sendTicketNotification(TicketDetailsUtil.convertToTicketDetails(userTicketDetails));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return updateMsg;
	}

}
