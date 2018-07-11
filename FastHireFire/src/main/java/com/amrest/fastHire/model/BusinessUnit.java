package com.amrest.fastHire.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "\"com.amrest.ph.db::Table.BUSINESS_UNITS\"", schema = "AMREST_PREHIRE")
@NamedQueries({ 
		@NamedQuery(name = "BusinessUnit.findAll", query = "SELECT bu FROM BusinessUnit bu"),
		@NamedQuery(name = "BusinessUnit.findDefaultBusinessUnit", query = "SELECT bu FROM BusinessUnit bu WHERE bu.isDefault = :isDefault")
		
})
public class BusinessUnit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "\"ID\"", columnDefinition = "INTEGER")
	private Integer id;
	
	@Column(name = "\"NAME\"",columnDefinition = "VARCHAR(32)")
     private String name;
	
	@Column(name = "\"IS_DEFAULT\"",columnDefinition = "BOOLEAN")
    private Boolean isDefault;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

}
