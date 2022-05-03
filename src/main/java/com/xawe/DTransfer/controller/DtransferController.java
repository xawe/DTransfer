package com.xawe.dtransfer.controller;

import java.time.Instant;
import java.util.Date;

import com.xawe.dtransfer.message.AvatarEnum;
import com.xawe.dtransfer.message.CowSay;
import com.xawe.dtransfer.service.DTransferFlowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/dtransfer", produces = "application/json;charset=UTF-8;")
public class DtransferController {
    
    @Autowired
    DTransferFlowService dtransferFlowService;

    /**
     * Endpoint responsável por sensibilzar o Dtransfer, executando novos fluxos e fluxos pendentes.
     * Operações:
     * 1 - Identifica se há novos fluxos e cadastra no banco com status de pronto para execução.
     * 2 - Executa todos os fluxos com status de Pronto para Execução seguindo a ordem descrita no campo Identifier
     * 3 - Marca os fluxos executados como Sucesso ou Erro, prevenindo futuras execuções
     * @return  WIP - ainda não definido os retornos
     */
    @GetMapping(value = "/execute")
    public ResponseEntity<String> executeDTransfer(){
        dtransferFlowService.execute();
        return ResponseEntity.ok().body(CowSay.getMessage(AvatarEnum.TUX, 
        "Execução finalizada com sucesso as "+ Date.from(Instant.now()).getTime()));
    }    
}
