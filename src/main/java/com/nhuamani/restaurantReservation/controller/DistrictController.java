package com.nhuamani.restaurantReservation.controller;

import com.nhuamani.restaurantReservation.dto.response.DistrictResponseDTO;
import com.nhuamani.restaurantReservation.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/districts")
public class DistrictController {

    private final DistrictService districtService;

    @GetMapping
    public ResponseEntity<List<DistrictResponseDTO>> getAllDistricts() {
        List<DistrictResponseDTO> districts = districtService.getAllDistricts();
        return ResponseEntity.ok(districts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistrictResponseDTO> getByIdDistrict(@PathVariable Long id) {
        DistrictResponseDTO district = districtService.getByIdDistrict(id);
        return ResponseEntity.ok(district);
    }

}
