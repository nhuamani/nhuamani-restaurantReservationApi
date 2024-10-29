package com.nhuamani.restaurantReservation.dto.response;

import com.nhuamani.restaurantReservation.domain.enums.Role;
import lombok.Data;

@Data
public class UserProfileResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}
