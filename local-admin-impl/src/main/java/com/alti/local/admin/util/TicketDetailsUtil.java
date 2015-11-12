/**
 * 
 */
package com.alti.local.admin.util;

import org.springframework.beans.BeanUtils;

import com.alti.local.admin.dao.model.UserTicketDetails;
import com.alti.local.admin.dto.TicketDetails;

/**
 * @author syandagudita
 *
 */
public class TicketDetailsUtil {
	
	public static TicketDetails convertToTicketDetails(UserTicketDetails userTckDtls) {
		
		TicketDetails targetTckDtls = new TicketDetails();
		BeanUtils.copyProperties(userTckDtls, targetTckDtls);
		
		return targetTckDtls;
	}
}
