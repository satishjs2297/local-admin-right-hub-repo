/**
 * 
 */
package com.alti.local.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alti.local.admin.dto.TicketDetails;
import com.alti.local.admin.service.LocalAdminService;

/**
 * @author syandagudita
 *
 */
public abstract class AbstractLocalAdminController {

	private static final Logger LOG = LoggerFactory
			.getLogger(AbstractLocalAdminController.class);

	@Autowired
	protected LocalAdminService localAdminService;

	@RequestMapping(value = "getTckDtls/{tckStatus}")
	public List<TicketDetails> getTicketDetails(
			@PathVariable("tckStatus") String ticketStatus) {
		LOG.debug("ticketStatus ::: {}", ticketStatus);
		List<TicketDetails> userTicketDetails = localAdminService
				.getUserTicketDetails(ticketStatus);
		LOG.info("userTicketDetails ::: {}", userTicketDetails);
		return userTicketDetails;
	}

	@RequestMapping(value = "updateTckDtls", method = RequestMethod.PUT)
	public String updateTicketDetails(@RequestBody TicketDetails tckDetails) {
		LOG.debug("tckDetails ::: {}", tckDetails);
		String updatedTicketDtls = localAdminService.updateUserTicketDetails(
				tckDetails.getUserRole(), tckDetails.getTicketId(),
				tckDetails.getStatus(), tckDetails.getManagerBJ());

		LOG.info("updatedTicketDtls ::: {}", updatedTicketDtls);

		return updatedTicketDtls;
	}
}
