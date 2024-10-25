package com.nhuamani.restaurantReservation.mapper;

import com.nhuamani.restaurantReservation.domain.entity.User;
import com.nhuamani.restaurantReservation.dto.request.SignupRequestDTO;
import com.nhuamani.restaurantReservation.dto.response.AuthResponseDTO;
import com.nhuamani.restaurantReservation.dto.response.UserProfileResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public User toUser(SignupRequestDTO signupRequestDTO) {
        return modelMapper.map(signupRequestDTO, User.class);
    }

    public UserProfileResponseDTO toUserProfileResponseDTO(User user) {
        return modelMapper.map(user, UserProfileResponseDTO.class);
    }

    public AuthResponseDTO toAuthResponseDTO(String token, UserProfileResponseDTO userProfile) {
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setToken(token);
        authResponseDTO.setUser(userProfile);
        return authResponseDTO;
    }
}
