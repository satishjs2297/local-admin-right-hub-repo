/**
 * 
 */
package com.alti.local.admin.dao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author syandagudita
 *
 */

@Entity
@Table(name = "LOCALADMINMAILCONTENT", catalog = "vigdb")
@IdClass(MailContentId.class)
public class LocalAdminMailContent  implements Serializable {

	
	private String eMailContent;

	@Id
	private String userType;
	
	@Id
	private String acctionType;
	
	public LocalAdminMailContent() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String geteMailContent() {
		return eMailContent;
	}
	public void seteMailContent(String eMailContent) {
		this.eMailContent = eMailContent;
	}

	
	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}

	
	public String getAcctionType() {
		return acctionType;
	}


	public void setAcctionType(String acctionType) {
		this.acctionType = acctionType;
	}

}

