/**
 * 
 */
package com.alti.local.admin.dao.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author syandagudita
 *
 */

public class MailContentId implements Serializable {
	
	private String userType;
	private String acctionType;
	
	public MailContentId() {
		// TODO Auto-generated constructor stub
	}
	
	public MailContentId(String userType, String acctionType) {
		this.userType = userType;
		this.acctionType = acctionType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((acctionType == null) ? 0 : acctionType.hashCode());
		result = prime * result
				+ ((userType == null) ? 0 : userType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MailContentId other = (MailContentId) obj;
		if (acctionType == null) {
			if (other.acctionType != null)
				return false;
		} else if (!acctionType.equals(other.acctionType))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}
	
	
	
		
}
