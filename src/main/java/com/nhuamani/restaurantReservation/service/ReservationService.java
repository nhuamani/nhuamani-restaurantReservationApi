package com.nhuamani.restaurantReservation.service;

import com.nhuamani.restaurantReservation.domain.entity.Reservation;
import com.nhuamani.restaurantReservation.domain.entity.Restaurant;
import com.nhuamani.restaurantReservation.domain.entity.User;
import com.nhuamani.restaurantReservation.domain.enums.ReservationStatus;
import com.nhuamani.restaurantReservation.dto.request.ReservationRequestDTO;
import com.nhuamani.restaurantReservation.dto.response.ReservationResponseDTO;
import com.nhuamani.restaurantReservation.exception.ResourceNotFoundException;
import com.nhuamani.restaurantReservation.mapper.ReservationMapper;
import com.nhuamani.restaurantReservation.repository.ReservationRepository;
import com.nhuamani.restaurantReservation.repository.RestaurantRepository;
import com.nhuamani.restaurantReservation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final ReservationMapper reservationMapper;

    @Transactional
    public ReservationResponseDTO createReservation(ReservationRequestDTO reservationRequestDTO) {
        // recupera los datos del usuario authenticado
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findOneByEmail(authentication.getName()).orElseThrow(() -> new ResourceNotFoundException("user not found by username"));

        Restaurant restaurant = restaurantRepository.findById(reservationRequestDTO.getRestaurantId()).orElseThrow(() -> new ResourceNotFoundException("restaurant not fount by id"));

        Reservation reservation = reservationMapper.toEntity(reservationRequestDTO);
        reservation.setRestaurant(restaurant);
        reservation.setClient(user);
        reservation.setStatus(ReservationStatus.PENDING);
        // reservation.setReservationDate(LocalDateTime.parse(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()))); // LocalDateTime.now()
        reservation.calculateTotalAmount();

        reservation = reservationRepository.save(reservation);

        return reservationMapper.toResponseDto(reservation);
    }


    @Transactional(readOnly = true)
    public List<ReservationResponseDTO> getReservationsByClientId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findOneByEmail(authentication.getName()).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        List<Reservation> reservations = reservationRepository.findByClientId(user.getId());
        return reservationMapper.toResponseDtoList(reservations);
    }


    @Transactional(readOnly = true)
    public ReservationResponseDTO getReservationById(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(() -> new ResourceNotFoundException("Reservation not found"));

        return reservationMapper.toResponseDto(reservation);
    }


    @Transactional
    public Reservation confirmReservationPayment(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(ResourceNotFoundException::new);

        reservation.setStatus(ReservationStatus.PAID);
        return reservationRepository.save(reservation);
    }
}
