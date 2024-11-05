package com.nhuamani.restaurantReservation.dto.paypal;

import lombok.Data;

@Data
public class Link {
    private String href;
    private String rel;
    private String method;
}
