package com.vehicle.dto.response;

public class VehicleResponseDTO {
    private int  vehicleId;
    private String vehicleName;

    private String registerationNumber;
    private String color;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getRegisterationNumber() {
        return registerationNumber;
    }

    public void setRegisterationNumber(String registerationNumber) {
        this.registerationNumber = registerationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
