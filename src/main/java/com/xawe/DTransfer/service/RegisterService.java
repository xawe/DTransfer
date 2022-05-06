package com.xawe.dtransfer.service;

import java.util.List;

import com.xawe.dtransfer.DataLoader;

public interface RegisterService {
    List<DataLoader> registerDataLoaders();
    List<DataLoader> initializeExistentLoaders();
}
