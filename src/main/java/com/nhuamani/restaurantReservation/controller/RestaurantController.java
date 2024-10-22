package com.nhuamani.restaurantReservation.controller;

import com.nhuamani.restaurantReservation.dto.response.RestaurantResponseDTO;
import com.nhuamani.restaurantReservation.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/page")
    public ResponseEntity<Page<RestaurantResponseDTO>> getAllRestaurants(@PageableDefault(sort = "name", size = 5) Pageable pageable) {
        Page<RestaurantResponseDTO> restaurants = restaurantService.getAllRestaurants(pageable);
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/page/district")
    public ResponseEntity<Page<RestaurantResponseDTO>> getByDistrictName(@RequestParam String districtName, @PageableDefault(sort = "name", size = 5) Pageable pageable) {
        Page<RestaurantResponseDTO> restaurants = restaurantService.getRestaurantsByDistrictName(districtName, pageable);
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDTO> getByIdRestaurants(@PathVariable Long id) {
        RestaurantResponseDTO restaurant = restaurantService.getRestaurantById(id);
        return ResponseEntity.ok(restaurant);
    }

}
