package com.nhuamani.restaurantReservation.dto.response;

import lombok.Data;

@Data
public class PaypalCaptureResponse {
    private boolean completed;
    private Long reservationId;
}
