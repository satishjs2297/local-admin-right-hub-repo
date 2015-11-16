/**
 * 
 */
package com.alti.local.admin.controller;

import java.util.List;

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

	@Autowired
	protected LocalAdminService localAdminService;

	@RequestMapping(value = "getTckDtls/{tckStatus}")
	public List<TicketDetails> getTicketDetails(
			@PathVariable("tckStatus") String ticketStatus) {
		System.out.println(">>>>>>>>>> tckStatus :: " + ticketStatus);
		List<TicketDetails> userTicketDetails = localAdminService
				.getUserTicketDetails(ticketStatus);
		return userTicketDetails;
	}

	@RequestMapping(value = "updateTckDtls", method = RequestMethod.PUT)
	public String updateTicketDetails(@RequestBody TicketDetails tckDetails) {

		String updatedTicketDtls = localAdminService.updateUserTicketDetails(tckDetails.getUserRole(),
				tckDetails.getTicketId(), tckDetails.getStatus(),
				tckDetails.getManagerBJ());
		
		return updatedTicketDtls;
	}
}
