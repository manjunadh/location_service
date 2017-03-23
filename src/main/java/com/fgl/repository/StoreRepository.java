package com.fgl.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

import com.fgl.model.Store;

public interface StoreRepository extends CrudRepository<Store, String> {

	List<Store> findByProvince(@Param("province") String province);

	List<Store> findByPointNear(@Param("location") Point location, @Param("distance") Distance distance);

}
