package com.vehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Vehicle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @NotNull
    private int vehicleId;
    @Column(nullable = false)
    @NotNull
    private String registerationNumner;
    @Column(nullable = false)
    @NotNull
    private String vehicleName;
    private String color;
    @Column(nullable = false)
    @NotNull

    @Enumerated(EnumType.STRING)
    private Type type;
    public enum Type{
        CAR,MOPED,BIKE

    }
    @NotNull
    @Column(nullable = false)
    private LocalDateTime associationActivatedAt;
    private  LocalDateTime associationDeactivatedAt;
    @NotNull
    private boolean isVehicleActive;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id")
    private Resident resident;
}
