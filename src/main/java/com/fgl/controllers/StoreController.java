package com.fgl.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fgl.model.Store;
import com.fgl.services.StoreService;

@RestController
public class StoreController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);
	@Autowired
	private StoreService storeService;

	@Bean
	StoreService storeService() {
		return new StoreService();
	}

	@RequestMapping("/locations/{id}")
	public Store getStorebyId(@PathVariable String id) {
		LOGGER.info("hitting /location/" + id + " controller");
		return storeService.getStoreById(id);

	}

	// single store
	@RequestMapping("/location/{storeNumber}")
	public List<Store> getStore(@PathVariable String storeNumber) {
		LOGGER.info("hitting /location/" + storeNumber + " controller");
		return storeService.getStore(storeNumber);

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
