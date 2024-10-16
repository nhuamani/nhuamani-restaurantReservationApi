package com.nhuamani.restaurantReservation.repository;

import com.nhuamani.restaurantReservation.domain.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    // JPQL = Java Persistence Query Language
    @Query("SELECT r FROM Restaurant r WHERE r.district.name = :districtName")
    Page<Restaurant> findByDistrictName(@Param("districtName") String districtName, Pageable pageable);

}
