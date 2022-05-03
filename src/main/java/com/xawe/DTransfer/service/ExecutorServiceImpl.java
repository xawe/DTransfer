package com.xawe.dtransfer.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.xawe.dtransfer.DataLoader;
import com.xawe.dtransfer.enums.DTransferStatusEnum;
import com.xawe.dtransfer.model.DTransferEntity;
import com.xawe.dtransfer.repository.DTransferRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExecutorServiceImpl implements ExecutorService {

    @Autowired
    private DTransferRepository repo;

    @Override
    public void execute(List<DataLoader> dataLoaders) {
        List<DTransferEntity> pendingItems =  repo.findByStatus(DTransferStatusEnum.PENDENTE.getStatus());
        pendingItems
        .stream()
        .sorted(Comparator.comparingInt(DTransferEntity::getStatus))
        .forEach(item -> {
            Optional<DataLoader> loader = dataLoaders
                .stream()
                .filter(d -> d.getIdentifier().equals(item.getIdentifier()))
                .findFirst();
            if(loader.isPresent()){
                try {
                    loader.get().execute();
                    System.out.println("Execution of " + loader.get().getIdentifier() + " Sucessful");    
                    item.setStatus(DTransferStatusEnum.EXECUTADO.getStatus());
                } catch (Exception e) {
                    System.out.println("Fail Loader execution ::: " + loader.get().getIdentifier() + " >> " + e);
                    item.setStatus(DTransferStatusEnum.ERRO.getStatus());
                } finally{
                    repo.saveAndFlush(item);
                }
                
            }
        });
        
    }
    
}
