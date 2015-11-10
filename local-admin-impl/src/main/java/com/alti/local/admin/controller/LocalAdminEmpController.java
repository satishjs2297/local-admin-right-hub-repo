/**
 * 
 */
package com.alti.local.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alti.local.admin.dto.User;
import com.alti.local.admin.dto.TicketDetails;

/**
 * @author syandagudita
 *
 */
@Controller
@RequestMapping("/ladmin")
public class LocalAdminEmpController {
		

	@RequestMapping(value = "/raisetck", method = RequestMethod.POST)
	public String adminHomePage(@ModelAttribute("user") User user) {
		
		System.out.println("LocalAdminEmp123333Controller#localAdminHome#Begin..." + user);
		
		return "employee/createtck";
	}
	
	@RequestMapping(value = "/submitreq", method = RequestMethod.POST)
	public ModelAndView createNewRequest(@RequestBody @ModelAttribute("userTckDtls") TicketDetails userticketdetails) {
		
		System.out.println("LocalAdminController#initiateRequest#");
		if(userticketdetails == null)
			throw new IllegalArgumentException("Userticketdetails is null");
		
		//Service call to persist userticketdetails details
	
		return new ModelAndView("employee/submittck");
	}
	
	
	
	
	
}
