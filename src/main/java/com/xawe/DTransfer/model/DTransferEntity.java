package com.xawe.DTransfer.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "data_entity")
public class DTransferEntity extends AuditModelEntity{
    
    @Id
	//@NotBlank
	@Column(columnDefinition = "text")
	private String dataName;

	@Column(columnDefinition = "text")
	private String description;
	
	@Column(columnDefinition = "int")
	private Integer status;
	
	@Column(columnDefinition = "bigint")
	private Long numericIdentifier;

	public Long getNumericIdentifier() {
		return numericIdentifier;
	}

	public void setNumericIdentifier(Long numericIdentifier) {
		this.numericIdentifier = numericIdentifier;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
    
}
