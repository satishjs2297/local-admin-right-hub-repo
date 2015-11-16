/**
 * 
 */
package com.alti.local.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alti.local.admin.dto.TicketDetails;
import com.alti.local.admin.service.LocalAdminService;

/**
 * @author syandagudita
 *
 */
@RestController
@RequestMapping("/ladmin-employee")
public class LocalAdminEmpController {
	
	@Autowired
	private LocalAdminService localAdminService;

	/*@RequestMapping(value = "/raisetck", method = RequestMethod.POST)
	public User adminHomePage(@RequestBody User user) {

		System.out
				.println("LocalAdminEmp123333Controller#localAdminHome#Begin..."
						+ user);
		user.setMobileNo("7418511474");

		return user;
	}*/

	@RequestMapping(value = "/submitreq", method = RequestMethod.POST)
	public String createNewRequest(@RequestBody TicketDetails userticketdetails) {

		System.out.println("LocalAdminController#initiateRequest#");
		if (userticketdetails == null)
			throw new IllegalArgumentException("Userticketdetails is null");

		// Service call to persist userticketdetails details
		String ticketId = localAdminService.saveUserTicketDetails(userticketdetails);
		
		return ticketId;
	}

}
