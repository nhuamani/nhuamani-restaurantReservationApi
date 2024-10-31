package com.nhuamani.restaurantReservation.repository;

import com.nhuamani.restaurantReservation.domain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.client.id = :clientId")
    List<Reservation> findByClientId(@Param("clientId") Long clientId);

}
