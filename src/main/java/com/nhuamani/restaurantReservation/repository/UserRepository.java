package com.nhuamani.restaurantReservation.repository;

import com.nhuamani.restaurantReservation.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
    boolean existsByEmail(String email);

}