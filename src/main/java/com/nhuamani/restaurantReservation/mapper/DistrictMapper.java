package com.nhuamani.restaurantReservation.mapper;

import com.nhuamani.restaurantReservation.domain.entity.District;
import com.nhuamani.restaurantReservation.dto.response.DistrictResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class DistrictMapper {

    private final ModelMapper modelMapper;

    public DistrictResponseDTO toResponseDto(District district) {
        return modelMapper.map(district, DistrictResponseDTO.class);
    }

    public List<DistrictResponseDTO> toResponseDtoList(List<District> districts) {
        return districts.stream()
                .map(this::toResponseDto)
                .toList();
    }
}
