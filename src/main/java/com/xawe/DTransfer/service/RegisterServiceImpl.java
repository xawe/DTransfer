package com.xawe.dtransfer.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xawe.dtransfer.DataLoader;
import com.xawe.dtransfer.enums.DTransferStatusEnum;
import com.xawe.dtransfer.model.DTransferEntity;
import com.xawe.dtransfer.repository.DTransferRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {


    @Autowired
    private DTransferRepository repo;

    @Override
    public List<DataLoader> registerDataLoaders() {
        List<DataLoader> dataLoaders = new ArrayList<>();         
        
        //TODO - O FindAll abaixo tende a ficar lento com o tempo Necessário alterar a estrategia para escalar
        List<DTransferEntity> registeredDTransfer =  repo.findAll();
        List<DataLoader> newLoaders = this.saveNewLoaders(dataLoaders,registeredDTransfer);        
        return newLoaders;
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
    
    private List<DataLoader> saveNewLoaders(List<DataLoader> loaders, List<DTransferEntity> dtransferEntities){
        List<DataLoader> newDataLoaders = this.filterNewOnly(loaders,dtransferEntities);
        List<DTransferEntity> dtransfer = new ArrayList<DTransferEntity>();
        for (DataLoader dl : newDataLoaders) {
            DTransferEntity dte = new DTransferEntity();
            dte.setCreatedAt(Date.from(Instant.now()));
            dte.setDescription(dl.getDescription());
            dte.setIdentifier(dl.getIdentifier());
            dte.setNumericIdentifier(this.getNumbers(dl.getIdentifier()));
            dte.setStatus(DTransferStatusEnum.PENDENTE.getStatus());
            dtransfer.add(dte);
        }

        Iterable<DTransferEntity> items = dtransfer;        
        repo.saveAllAndFlush(items);
        return newDataLoaders;
    }


    private Long getNumbers(String data) {
		String s=data.replaceAll("[^0-9]+", "");
		System.out.println(s);
		return Long.parseLong(s);
        
	}
}
