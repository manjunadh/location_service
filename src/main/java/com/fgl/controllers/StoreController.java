package com.fgl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fgl.model.Store;
import com.fgl.services.StoreService;
import com.fgl.services.StoreServiceImpl;

@RestController
public class StoreController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);
	@Autowired
	private StoreService storeService;

	@Bean
	StoreService storeService() {
		return new StoreServiceImpl();
	}

	// single store
	@RequestMapping("/location/{storeNumber}")
	public Store getStore(@PathVariable String storeNumber) {
		LOGGER.info("hitting /location/" + storeNumber + " controller");
		Store store = storeService.getStore(storeNumber);
		return store;

	}

	@RequestMapping("/")
	public String home() {
		LOGGER.info("hitting /location/home");
		return "home page";
	}

	// all stores
	@RequestMapping("/location/")
	public List<Store> getAllStores() {
		LOGGER.info("hitting /location/ controller");
		List<Store> stores = storeService.getAllStores();
		return stores;

	}

	// all stores by province
	@RequestMapping("/location/province/{province}")
	public List<Store> getAllStoresByProvince(@PathVariable String province) {
		LOGGER.info("hitting province /location/" + province + " controller");
		List<Store> stores = storeService.getAllStoresForProvince(province);
		return stores;

	}

	// all stores nearby (default 5km)
	// @RequestMapping("/location/nearby/{storeNumber}")
	// public List<Store> getAllStoresNearby(@PathVariable String storeNumber) {
	//
	// List<Store> stores = storeService.getAllStoresNearby(storeNumber);
	// return stores;

	// }

}
