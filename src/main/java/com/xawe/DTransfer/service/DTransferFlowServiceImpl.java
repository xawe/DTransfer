package com.xawe.dtransfer.service;

import java.util.List;

import com.xawe.dtransfer.DataLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DTransferFlowServiceImpl implements DTransferFlowService {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private ExecutorService executorService;

    @Override
    public void execute() {
       List<DataLoader> dataLoaders = registerService.registerDataLoaders();
       executorService.execute(dataLoaders);
        
    }

    @Override
    public void rollback() {
        // TODO Auto-generated method stub
        
    }
    
}
