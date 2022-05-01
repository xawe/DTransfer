package com.xawe.dtransfer;

public abstract class DataLoader {
    private String identifier;
	private String description;
	
	public void execute() {
		
	}
	
	public void rollback() {
		
	}
	
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
