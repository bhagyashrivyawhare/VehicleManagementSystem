package com.vehicle.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Vehicle {


    private static @NotNull Vehicle.@NotNull Type Type;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @NotNull
    private int vehicleId;


    @Column(name = "registeration_number", nullable = false)
    @NotNull
    private String registerationNumber;
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
    @JsonIgnore
    private LocalDateTime associationActivatedAt;
    @JsonIgnore
    private  LocalDateTime associationDeactivatedAt;
    @NotNull
    private boolean isVehicleActive;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id")

    private Resident resident;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getRegisterationNumber() {
        return registerationNumber;
    }

    public void setRegisterationNumber(String registerationNumber) {
        this.registerationNumber = registerationNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public @NotNull Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDateTime getAssociationActivatedAt() {
        return associationActivatedAt;
    }

    public void setAssociationActivatedAt(LocalDateTime associationActivatedAt) {
        this.associationActivatedAt = associationActivatedAt;
    }

    public LocalDateTime getAssociationDeactivatedAt() {
        return associationDeactivatedAt;
    }

    public void setAssociationDeactivatedAt(LocalDateTime associationDeactivatedAt) {
        this.associationDeactivatedAt = associationDeactivatedAt;
    }

    public boolean isVehicleActive() {
        return isVehicleActive;
    }

    public void setVehicleActive(boolean vehicleActive) {
        isVehicleActive = vehicleActive;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }
}
