package com.nhuamani.restaurantReservation.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Size(max = 11)
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "price_per_person", nullable = false)
    private double pricePerPerson;
    @Column(name = "capacity", nullable = false)
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "district_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_RESTAURANT_DISTRICT")
    )
    private District district;
}
