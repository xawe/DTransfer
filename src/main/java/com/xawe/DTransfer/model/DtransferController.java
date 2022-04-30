package com.xawe.dtransfer.model;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/dtransfer", produces = "application/json;charset=UTF-8;")
public class DtransferController {
    
    @GetMapping(value = "/execute")
    public ResponseEntity<String> executeDTransfer(){
        return ResponseEntity.ok().body("Sucess");
    }
}
