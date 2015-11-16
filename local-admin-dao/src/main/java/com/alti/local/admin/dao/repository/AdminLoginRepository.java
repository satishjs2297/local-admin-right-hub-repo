/**
 * 
 */
package com.alti.local.admin.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alti.local.admin.dao.model.ITAdminUser;

/**
 * @author syandagudita
 *
 */
public interface AdminLoginRepository extends JpaRepository<ITAdminUser, String>{
	
	public ITAdminUser findUserByUserIdAndPasswordAndStatus(String userId, String password,String status);
	

	@Query(value = "from ITAdminUser where status=:status")
	public List<ITAdminUser> findAllByStatus(@Param("status") String status);

}
