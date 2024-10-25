package com.nhuamani.restaurantReservation.dto.request;

import lombok.Data;

@Data
public class AuthRequestDTO {
    private String email;
    private String password;
}
