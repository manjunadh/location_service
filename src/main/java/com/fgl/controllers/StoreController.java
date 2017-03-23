package com.fgl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fgl.model.Store;
import com.fgl.services.StoreService;
import com.fgl.services.StoreServiceImpl;

/**
 * Created by rhett on 2017-03-15.
 */
@RestController
public class StoreController {

	@Autowired
	private StoreService storeService;

	@Bean
	StoreService storeService() {
		return new StoreServiceImpl();
	}

	// single store
	@RequestMapping("/location/{storeNumber}")
	public Store getStore(@PathVariable String storeNumber) {

		Store store = storeService.getStore(storeNumber);
		return store;

	}

	// all stores
	@RequestMapping("/location/")
	public List<Store> getAllStores() {

		List<Store> stores = storeService.getAllStores();
		return stores;

	}

	// all stores by province
	@RequestMapping("/location/province/{province}")
	public List<Store> getAllStoresByProvince(@PathVariable String province) {

		List<Store> stores = storeService.getAllStoresForProvince(province);
		return stores;

	}

	// all stores nearby (default 5km)
//	@RequestMapping("/location/nearby/{storeNumber}")
//	public List<Store> getAllStoresNearby(@PathVariable String storeNumber) {
//
//		List<Store> stores = storeService.getAllStoresNearby(storeNumber);
//		return stores;

//	}

}
