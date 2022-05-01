package com.xawe.dtransfer.repository;

import com.xawe.dtransfer.model.DTransferEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DTransferRepository extends JpaRepository<DTransferEntity, String> {
    
}
