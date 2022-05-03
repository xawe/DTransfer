package com.xawe.dtransfer.load;

import com.xawe.dtransfer.DataLoader;

import org.springframework.stereotype.Service;

@Service
public class CreateDummy202205022153 extends DataLoader{

    public CreateDummy202205022153(){
        this.setIdentifier("CreateDummy202205022153");
        this.setDescription("Class dummy sequence 4");
    }

    @Override
    public void execute() {        
        System.out.println("Executing dummy class sequence 4q");
    }
    
}
