package com.nhuamani.restaurantReservation.service;

import com.nhuamani.restaurantReservation.domain.entity.Restaurant;
import com.nhuamani.restaurantReservation.dto.response.RestaurantResponseDTO;
import com.nhuamani.restaurantReservation.exception.ResourceNotFoundException;
import com.nhuamani.restaurantReservation.mapper.RestaurantMapper;
import com.nhuamani.restaurantReservation.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Transactional(readOnly = true)
    public Page<RestaurantResponseDTO> getAllRestaurants(Pageable pageable) {
        Page<Restaurant> restaurants = restaurantRepository.findAll(pageable);
        return restaurants.map(restaurantMapper::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public Page<RestaurantResponseDTO> getRestaurantsByDistrictName(String districtName, Pageable pageable) {
        Page<Restaurant> restaurants = restaurantRepository.findByDistrictName(districtName, pageable);
        return restaurants.map(restaurantMapper::toResponseDTO);
    }

    public RestaurantResponseDTO getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));
        return restaurantMapper.toResponseDTO(restaurant);
    }

}
