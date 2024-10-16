package com.nhuamani.restaurantReservation.mapper;

import com.nhuamani.restaurantReservation.domain.entity.Restaurant;
import com.nhuamani.restaurantReservation.dto.response.RestaurantResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class RestaurantMapper {

    private final ModelMapper modelMapper;

    public RestaurantResponseDTO toResponseDTO(Restaurant restaurant) {
        return modelMapper.map(restaurant, RestaurantResponseDTO.class);
    }

    public List<RestaurantResponseDTO> toResponseDTOList(List<Restaurant> restaurants) {
        return restaurants.stream()
                .map(this::toResponseDTO)
                .toList();
    }
}
