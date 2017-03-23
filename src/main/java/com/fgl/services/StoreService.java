package com.fgl.services;

import java.util.List;

import com.fgl.model.Store;


public interface StoreService {


    public Store getStore(String storeNumber);
    public List<Store> getAllStores();
    public List<Store> getAllStoresForProvince(String province);

//    List<Store> getAllStoresNearby(String storeNumber);
}
