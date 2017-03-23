package com.fgl.services;

import java.util.List;

import com.fgl.model.Store;

/**
 * Created by rhett on 2017-03-16.
 */
public interface StoreService {


    public Store getStore(String storeNumber);
    public List<Store> getAllStores();
    public List<Store> getAllStoresForProvince(String province);

    List<Store> getAllStoresNearby(String storeNumber);
}
