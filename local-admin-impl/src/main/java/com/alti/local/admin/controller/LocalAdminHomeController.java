/**
 * 
 */
package com.alti.local.admin.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alti.local.admin.security.user.ApplicationUser;

/**
 * @author syandagudita
 *
 */
@Controller
public class LocalAdminHomeController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String rootAdmin(ModelMap model) {
		return "redirect:router";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "denied";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}
	
	@RequestMapping(value = "/router", method = RequestMethod.GET)
	public String routeUser(ModelMap model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			System.out.println("auth.getPrincipal() ::: " + auth.getPrincipal());
			if(auth.getPrincipal() instanceof ApplicationUser) {
				System.out.println("ApplicationUser  check...........");
				System.out.println(">>>>>>>>"+((ApplicationUser)auth.getPrincipal()).getUsername());
				ApplicationUser appUser = (ApplicationUser) auth.getPrincipal();
				model.addAttribute("userDtlsMap", appUser.getUserDataMap());
			} 
		}
		return "show";
	}
	
}
