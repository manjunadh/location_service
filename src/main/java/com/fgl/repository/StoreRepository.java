package com.fgl.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fgl.model.Store;

public interface StoreRepository extends CrudRepository<Store, String> {

	List<Store> findByProvince(@Param("province") String province);
	List<Store> findByStoreNumber(@Param("province") int storeNumber);
//	List<Store> findByPointNear(@Param("location") Point location, @Param("distance") Distance distance);

}
