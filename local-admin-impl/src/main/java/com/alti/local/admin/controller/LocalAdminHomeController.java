/**
 * 
 */
package com.alti.local.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	private static final Logger LOG = LoggerFactory
			.getLogger(LocalAdminHomeController.class);

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String rootAdmin(ModelMap model) {
		LOG.debug("Model ::: {}",model);
		return "redirect:router";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		LOG.debug("Model ::: {}",model);
		return "login";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		LOG.debug("Model ::: {}",model);
		model.addAttribute("error", "true");
		return "denied";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		LOG.debug("Model ::: {}",model);
		return "logout";
	}
	
	@RequestMapping(value = "/router", method = RequestMethod.GET)
	public String routeUser(ModelMap model) {
		LOG.debug("Model begin ::: {}",model);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			LOG.debug("Not AnonymousAuthenticationToken");
			Object principal = auth.getPrincipal() ;
			if(principal instanceof ApplicationUser) {
				LOG.debug("principal is instanceof ApplicationUser ");
				ApplicationUser appUser = (ApplicationUser) auth.getPrincipal();
				model.addAttribute("userDtlsMap", appUser.getUserDataMap());
			} 
		}
		return "routeuser";
	}
	
}
