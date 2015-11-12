/**
 * 
 */
package com.alti.local.admin.controller;

import static com.alti.local.admin.util.LocalAdminConstants.EMP_ROLEID;
import static com.alti.local.admin.util.LocalAdminConstants.ITAGENT_ROLEID;
import static com.alti.local.admin.util.LocalAdminConstants.MANAGER_ROLEID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alti.local.admin.dto.User;
import com.alti.local.admin.exception.ViewNotFoundException;

/**
 * @author syandagudita
 *
 */
@Controller
@RequestMapping("/ahome")
@Deprecated
public class LocalAdminHomeController {

	
	@RequestMapping(value = "/router")
	public String postLoginRouter(@RequestBody User userDtls, Model model) {
		
		String viewName = null;
		String userRoleId = userDtls.getUserRole();
		
		userRoleId = "3";
		model.addAttribute("user", userDtls);
		model.addAttribute("greetings", "checking expression");
		
		if(MANAGER_ROLEID.equals(userRoleId)) {
			viewName = "manager/ticketlsthome";
		} else if(ITAGENT_ROLEID.equals(userRoleId)) {
			viewName = "admin/ticketlsthome";
		} else if(EMP_ROLEID.equals(userRoleId)) {
			viewName = "employee/createtck";
		} else {
			throw new ViewNotFoundException("View is not located for roleId = "+ userRoleId);
		}
		return viewName;
	}
}
