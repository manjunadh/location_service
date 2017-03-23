package com.fgl.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
//import org.springframework.data.geo.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fgl.model.Store;
import com.fgl.repository.StoreRepository;
import com.fgl.repository.StoreRepositoryImpl;

public class StoreServiceImpl implements StoreService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StoreServiceImpl.class);
	private static final Distance distance = new Distance(50, Metrics.KILOMETERS);
	@Autowired
	private StoreRepository storeRepository;

	@Bean
	StoreRepository storeRepository() {
		return new StoreRepositoryImpl();
	}

	@Override
	public Store getStore(String storeNumber) {
		LOGGER.info("get by store number service" + storeNumber);
		return storeRepository.findOne(storeNumber);
	}

	@Override
	public List<Store> getAllStores() {
		LOGGER.info("get all stores service");
		List<Store> stores = new ArrayList<>();
		storeRepository.findAll().forEach(stores::add);
		return stores;
	}

	@Override
	public List<Store> getAllStoresForProvince(String province) {
		LOGGER.info("get stores by provience service");
		return storeRepository.findByProvince(province);
	}

	@Override
	public List<Store> getAllStoresNearby(String storeNumber) {
		Store store = storeRepository.findOne(storeNumber);
		return storeRepository.findByPointNear(store.getLocation(), distance);

	}

}
