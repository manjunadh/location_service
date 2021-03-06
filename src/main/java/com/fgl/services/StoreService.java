package com.fgl.services;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.data.geo.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fgl.model.Store;
import com.fgl.repository.StoreRepository;

@Service
@Transactional
public class StoreService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StoreService.class);
	public static final String storeService = "created";
	// private static final Distance distance = new Distance(50,
	// Metrics.KILOMETERS);
	@Autowired
	private StoreRepository storeRepository;

	// public List<Store> getStore(int storeNumber) {
	// LOGGER.info("get by store number service" + storeNumber);
	// return storeRepository.findByStoreNumber(storeNumber);
	// }

	public List<Store> getAllStores() {
		LOGGER.info("get all stores service");
		List<Store> stores = new ArrayList<>();

		storeRepository.findAll().forEach(stores::add);
		return stores;
	}

	public List<Store> getAllStoresForProvince(String province) {
		LOGGER.info("get stores by provience service");
		return storeRepository.findByProvince(province);
	}

	public Store getStoreById(String id) {

		return storeRepository.findOne(id);
	}

}
