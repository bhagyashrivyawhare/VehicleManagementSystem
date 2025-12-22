package com.vehicle.dto.request;

import com.vehicle.entity.Vehicle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VehicleDTO {

    @NotBlank(message = "Registration number is required")
    private String registerationNumber;

    @NotBlank(message = "Vehicle name is required")
    private String vehicleName;

    private String color;

    @NotNull(message = "Vehicle type is required")
    private Vehicle.Type type;

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

    public Vehicle.Type getType() {
        return type;
    }

    public void setType(Vehicle.Type type) {
        this.type = type;
    }
}
