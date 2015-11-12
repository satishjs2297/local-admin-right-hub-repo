package com.alti.local.admin.dao.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

/**
 * @author syandagudita
 */
@MappedSuperclass
public abstract class BaseEntity<ID> {

    @Column(name = "creation_time", nullable = false)
    private Timestamp creationTime;

    @Column(name = "modification_time", nullable = false)
    private Timestamp modificationTime;

    @Version
    private long version;

    //public abstract ID getId();

 
    public long getVersion() {
        return version;
    }

    @PrePersist
    public void prePersist() {
    	Timestamp now = new Timestamp(System.currentTimeMillis());
        this.creationTime = now;
        this.modificationTime = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.modificationTime = new Timestamp(System.currentTimeMillis());
    }


	public Timestamp getCreationTime() {
		return creationTime;
	}


	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}


	public Timestamp getModificationTime() {
		return modificationTime;
	}


	public void setModificationTime(Timestamp modificationTime) {
		this.modificationTime = modificationTime;
	}


	public void setVersion(long version) {
		this.version = version;
	}
}


