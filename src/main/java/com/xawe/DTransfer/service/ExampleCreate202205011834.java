package com.xawe.dtransfer.service;

import com.xawe.dtransfer.DataLoader;

import org.springframework.stereotype.Service;

@Service
public class ExampleCreate202205011834 extends DataLoader {
    
    public ExampleCreate202205011834(){
        this.setDescription("Apenas uma classe de teste, sem carga alguma");
        this.setIdentifier("ExampleCreate202205011834");        
    }

    @Override
    public void execute(){
        System.out.println("Executing dummy class");
    }
}
