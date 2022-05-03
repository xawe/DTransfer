package com.xawe.dtransfer.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xawe.dtransfer.DataLoader;
import com.xawe.dtransfer.enums.DTransferStatusEnum;
import com.xawe.dtransfer.load.CreateDummy202205022145;
import com.xawe.dtransfer.load.CreateDummy202205022148;
import com.xawe.dtransfer.load.CreateDummy202205022153;
import com.xawe.dtransfer.load.ExampleCreate202205011834;
import com.xawe.dtransfer.model.DTransferEntity;
import com.xawe.dtransfer.repository.DTransferRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {


    @Autowired
    private DTransferRepository repo;

    @Autowired
    private ExampleCreate202205011834 createExample;

    @Autowired
    private CreateDummy202205022145 create2145;

    @Autowired
    private CreateDummy202205022148 create2148;
    @Autowired
    private CreateDummy202205022153 create2153;

    @Override
    public List<DataLoader> registerDataLoaders() {
        List<DataLoader> dataLoaders = new ArrayList<>();         
        dataLoaders.add(createExample);
        dataLoaders.add(create2145);
        dataLoaders.add(create2148);
        dataLoaders.add(create2153);
        
        //TODO - O FindAll abaixo tende a ficar lento com o tempo Necessário alterar a estrategia para escalar
        List<DTransferEntity> registeredDTransfer =  repo.findAll();
        this.saveNewLoaders(dataLoaders,registeredDTransfer);        
        return dataLoaders;
    }

    /**
     * verifica se o loader que está sendo carregado já está cadastrado no banco, 
     * retornando apenas os que ainda não foram cadastrados
     * @param loaders
     * @param dtransferEntities
     * @return lista com dataLoaders que devem ser gravados no banco com status de pendente ( novos Loaders )
     */
    private List<DataLoader> filterNewOnly(List<DataLoader> loaders, List<DTransferEntity> dtransferEntities){
        List<DataLoader> newLoaders = new ArrayList<DataLoader>();
        for (DataLoader dataLoader : loaders) {
            if(!dtransferEntities.stream().anyMatch(e -> e.getIdentifier().equals(dataLoader.getIdentifier()))){
                newLoaders.add(dataLoader);
            }
        }
        return newLoaders;
    }
    
    private void saveNewLoaders(List<DataLoader> loaders, List<DTransferEntity> dtransferEntities){
        List<DataLoader> newDataLoaders = this.filterNewOnly(loaders,dtransferEntities);
        List<DTransferEntity> dtransfer = new ArrayList<DTransferEntity>();
        for (DataLoader dl : newDataLoaders) {
            DTransferEntity dte = new DTransferEntity();
            Date createdOn = Date.from(Instant.now());
            dte.setCreatedAt(createdOn);
            dte.setUpdatedAt(createdOn);
            dte.setDescription(dl.getDescription());
            dte.setIdentifier(dl.getIdentifier());
            dte.setNumericIdentifier(this.getNumbers(dl.getIdentifier()));
            dte.setStatus(DTransferStatusEnum.PENDENTE.getStatus());
            dtransfer.add(dte);
        }

        if(dtransfer.size()>0){
            Iterable<DTransferEntity> items = dtransfer; 
            try {
                repo.saveAll(items);            
            } catch (Exception e) {
                System.out.println("Erro ao gravar dados ::: " + e);
            }       
        }
        
    }


    private Long getNumbers(String data) {
		String s=data.replaceAll("[^0-9]+", "");
		System.out.println(s);
		return Long.parseLong(s);
        
	}
}
