package com.nhuamani.restaurantReservation.controller;

import com.nhuamani.restaurantReservation.dto.request.ReservationRequestDTO;
import com.nhuamani.restaurantReservation.dto.response.ReservationResponseDTO;
import com.nhuamani.restaurantReservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping()
    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody @Validated ReservationRequestDTO reservationRequestDTO) {
        ReservationResponseDTO reservationResponse = reservationService.createReservation(reservationRequestDTO);
        System.out.println(reservationResponse);

        return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
    }


    @GetMapping("/my-reservations")
    public ResponseEntity<List<ReservationResponseDTO>> getMyReservations() {
        List<ReservationResponseDTO> reservations = reservationService.getReservationsByClientId();

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> getReservationById(@PathVariable Long id) {
        ReservationResponseDTO reservation = reservationService.getReservationById(id);

        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

}
