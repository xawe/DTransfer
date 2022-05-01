package com.xawe.dtransfer;

/**
 * Classe responsável por descrever o modelo a ser aplicado nas classe de transferencia dedados
 */
public abstract class DataLoader {
    /**
     * identificador da classe de operação
     */
    private String identifier;

    /**
     * descrição da classe de operação (apenas informativo)
     */
	private String description;
	
    /**
     * Descreve as operações a serem aplicadas no banco de dados
     */
	public void execute() {
		
	}
	
    /**
     * Descreve as operações de rollback a serem aplicadas no banco
     */
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
