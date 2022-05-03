package com.xawe.dtransfer.service;

import java.util.List;

import com.xawe.dtransfer.DataLoader;

public interface ExecutorService {
    void execute(List<DataLoader> dataLoaders);
}
