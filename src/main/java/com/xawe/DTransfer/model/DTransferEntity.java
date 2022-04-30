package com.xawe.DTransfer.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/***
 * Classe responsável por armazenar um registro de controle para cada nova implementação de execução.
 * 
 */
@Entity
@Table(name = "Dtransfer")
public class DTransferEntity extends AuditModelEntity{
   
	/**
	 * Chave usada para identificar o registro de execução
	 * Recomendação - Sempre conter no nome o padrão YYYYMMDDHHmm
	 * EX: 202204301047
	 * Dessa forma, a ordem de execução das diversas cargas poderá ser mantida de acordo
	 *  com a nomeclatura utilizada
	 */
    @Id
	//@NotBlank
	@Column(columnDefinition = "text")
	private String identifier;

	/**
	 * Descrição do registro
	 * Serve apenas para facilitar o entendimento a respeito das fronteiras do registro de execução
	 */
	@Column(columnDefinition = "text")
	private String description;
	
	/**
	 * Status da execução
	 * Identifica o estado atual sendo:
	 * 1 - Pendente ( ainda não executado)
	 * 2 - Executado ( a migração já foi executada com sucesso e não deve ser mais executada)
	 * 3 - Erro ( ocorreu um erro durante a execução. Possivelmente a implementação de execução
	 * 	de dados possui uma falha e não deverá ser reexecutada)
	 */
	@Column(columnDefinition = "int")
	private Integer status;
	
	/**
	 * Identificador númerico. É a mesma informação contida na coluna Identifier apenas com os dados numericos.
	 * Usada internamente para ordenação de execução
	 */
	@Column(columnDefinition = "bigint")
	private Long numericIdentifier;

	public Long getNumericIdentifier() {
		return numericIdentifier;
	}

	public void setNumericIdentifier(Long numericIdentifier) {
		this.numericIdentifier = numericIdentifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setDataName(String identifier) {
		this.identifier = identifier;
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
