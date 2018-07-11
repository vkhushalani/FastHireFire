package com.amrest.fastHire.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.amrest.ph.db::Table.HIRING_TEMPLATE\"", schema = "AMREST_PREHIRE")
@NamedQueries({ 
		@NamedQuery(name = "Template.findAll", query = "SELECT t FROM Template t"),
		@NamedQuery(name = "Template.findDefaultTemplate", query = "SELECT t FROM Template t WHERE t.isDefault = :isDefault")
		
})
public class Template {
	@Id
	@Column(name = "\"ID\"", columnDefinition = "VARCHAR(10)")
	private String id;
	
	@Column(name = "\"NAME\"",columnDefinition = "VARCHAR(32)")
     private String name;
	
	@Column(name = "\"STATUS\"", columnDefinition = "BOOLEAN")
	private Boolean status;
	
	@Column(name = "\"EFFECTIVE_DATE\"",columnDefinition = "SECONDDATE")
     private Date effectiveDate;
	
	@Column(name = "\"CHANGED_BY\"", columnDefinition = "VARCHAR(10)")
	private String changedBy;
	
	@Column(name = "\"CATEGORY\"",columnDefinition = "VARCHAR(32)")
     private String category;
	
	@Column(name = "\"IS_DEFAULT\"", columnDefinition = "BOOLEAN")
	private Boolean isDefault;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
	
}
