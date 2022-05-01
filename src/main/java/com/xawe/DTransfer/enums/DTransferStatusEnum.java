package com.xawe.dtransfer.enums;

public enum DTransferStatusEnum {
    PENDENTE(1),
	EXECUTADO(2),
	ERRO(3);
	
	private final Integer status;
	
	private DTransferStatusEnum(Integer status) {
        this.status = status;
    }
	
	public int getStatus() {
        return this.status;
    }
}
