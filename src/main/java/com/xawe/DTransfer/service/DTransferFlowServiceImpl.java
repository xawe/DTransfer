package com.xawe.dtransfer.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.xawe.dtransfer.DataLoader;
import com.xawe.dtransfer.model.DTransferEntity;
import com.xawe.dtransfer.repository.DTransferRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DTransferFlowServiceImpl implements DTransferFlowService {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private DTransferRepository repo;

    @Override
    public void execute() {
        List<DataLoader> dataLoaders = registerService.registerDataLoaders();
        executorService.execute(dataLoaders);

    }

    @Override
    public void rollback() {
        Optional<DTransferEntity> dTransfer = repo.findAll()
                .stream()                
                .sorted(Comparator.comparingInt(DTransferEntity::getStatus).reversed())
                .findFirst();

                //////WIP ---- implementar order reversa
                Optional<DTransferEntity> dTransfer2 = repo.findAll()
                .stream()                
                .min(Comparator.comparing(DTransferEntity::getStatus));

        List<DataLoader> dataLoaders = registerService.initializeExistentLoaders();
        
        if (dTransfer.isPresent()) {
           DataLoader loader = dataLoaders
            .stream()
            .filter(d -> d.getIdentifier().equals(dTransfer.get().getIdentifier()))
            .findFirst()
            .get();

            loader.rollback();
        }

    }

}
