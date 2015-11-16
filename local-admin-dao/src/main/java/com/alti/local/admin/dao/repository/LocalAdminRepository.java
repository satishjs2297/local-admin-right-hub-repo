/**
 * 
 */
package com.alti.local.admin.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alti.local.admin.dao.model.UserTicketDetails;

/**
 * @author syandagudita
 *
 */
public interface LocalAdminRepository extends JpaRepository<UserTicketDetails, String>{
	
	
	public List<UserTicketDetails> findUserTicketDetailsByStatus(String status);
	
	@Override
	public UserTicketDetails findOne(String ticketId);
	

}
