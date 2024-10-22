package com.nhuamani.restaurantReservation.service;

import com.nhuamani.restaurantReservation.domain.entity.District;
import com.nhuamani.restaurantReservation.dto.response.DistrictResponseDTO;
import com.nhuamani.restaurantReservation.exception.ResourceNotFoundException;
import com.nhuamani.restaurantReservation.mapper.DistrictMapper;
import com.nhuamani.restaurantReservation.repository.DistrictRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DistrictService {

    private final DistrictRespository districtRespository;
    private final DistrictMapper districtMapper;

    @Transactional(readOnly = true)
    public List<DistrictResponseDTO> getAllDistricts() {
        List<District> districts = districtRespository.findAll();
        return districtMapper.toResponseDtoList(districts);
    }

    public DistrictResponseDTO getByIdDistrict(Long id) {
        District district = districtRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("District not found with id: " + id));
        return districtMapper.toResponseDto(district);
    }

}
