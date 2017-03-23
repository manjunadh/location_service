package com.fgl.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;

import com.fgl.model.Store;
import com.fgl.repository.StoreRepository;

public class StoreServiceImpl implements StoreService {
	private static final Distance distance = new Distance(50, Metrics.KILOMETERS);
	@Autowired
	private StoreRepository storeRepository;

@Bean
StoreRepository storeRepository(){
	return new StoreRepository() {
		
		@Override
		public <S extends Store> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Store> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Store findOne(String id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Iterable<Store> findAll(Iterable<String> ids) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Iterable<Store> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean exists(String id) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(Iterable<? extends Store> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(Store entity) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(String id) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public List<Store> findByProvince(String province) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Store> findByPointNear(Point location, Distance distance) {
			// TODO Auto-generated method stub
			return null;
		}
	};
}



	@Override
	public Store getStore(String storeNumber) {
		return storeRepository.findOne(storeNumber);
	}

	@Override
	public List<Store> getAllStores() {
		List<Store> stores = new ArrayList<>();
		storeRepository.findAll().forEach(stores::add);
		return stores;
	}

	@Override
	public List<Store> getAllStoresForProvince(String province) {
		return storeRepository.findByProvince(province);
	}

	@Override
	public List<Store> getAllStoresNearby(String storeNumber) {
		Store store= storeRepository.findOne(storeNumber);
		return storeRepository.findByPointNear(store.getLocation(),distance);
		
	}

}
