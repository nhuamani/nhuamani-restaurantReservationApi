package com.nhuamani.restaurantReservation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PaypalOrderResponse {
    private String paypalUrl;
}
