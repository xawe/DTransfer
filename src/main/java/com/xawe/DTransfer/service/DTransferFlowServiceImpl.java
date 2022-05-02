package com.xawe.dtransfer.service;

import java.util.List;

import com.xawe.dtransfer.DataLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DTransferFlowServiceImpl implements DTransferFlowService {

    @Autowired
    RegisterService registerService;

    @Override
    public void execute() {
       List<DataLoader> dataLoaders = registerService.registerDataLoaders();
       
        
    }

    @Override
    public void rollback() {
        // TODO Auto-generated method stub
        
    }
    
}
