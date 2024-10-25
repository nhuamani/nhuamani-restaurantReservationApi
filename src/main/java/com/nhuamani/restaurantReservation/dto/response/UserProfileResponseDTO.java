package com.nhuamani.restaurantReservation.dto.response;

import com.nhuamani.restaurantReservation.domain.enums.Role;

public class UserProfileResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}
