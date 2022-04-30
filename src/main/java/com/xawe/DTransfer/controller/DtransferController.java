package com.xawe.dtransfer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/dtransfer", produces = "application/json;charset=UTF-8;")
public class DtransferController {
    
    /**
     * Endpoint responsável por sensibilzar o Dtransfer, executando novos fluxos e fluxos pendentes.
     * Operações:
     * 1 - Identifica se há novos fluxos e cadastra no banco com status de pronto para execução.
     * 2 - Executa todos os fluxos com status de Pronto para Execução seguindo a ordem descrita no campo Identifier
     * 3 - Marca os fluxos executados como Sucesso ou Erro, prevenindo futuras execuções
     * @return
     */
    @GetMapping(value = "/execute")
    public ResponseEntity<String> executeDTransfer(){
        return ResponseEntity.ok().body("Sucess");
    }
}
