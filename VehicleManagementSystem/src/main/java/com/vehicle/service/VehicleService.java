package com.vehicle.service;

import com.vehicle.dto.request.VehicleDTO;
import com.vehicle.entity.Vehicle;

public interface VehicleService {
    public Vehicle createVehicle(VehicleDTO dto);
}
