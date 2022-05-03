package com.xawe.dtransfer.load;

import com.xawe.dtransfer.DataLoader;

import org.springframework.stereotype.Service;

@Service
public class CreateDummy202205022145 extends DataLoader{

    public CreateDummy202205022145(){
        this.setIdentifier("CreateDummy202205022145");
        this.setDescription("Class dummy sequence 2");
    }

    @Override
    public void execute() {        
        System.out.println("Executing dummy class sequence 2");
    }
    
}
