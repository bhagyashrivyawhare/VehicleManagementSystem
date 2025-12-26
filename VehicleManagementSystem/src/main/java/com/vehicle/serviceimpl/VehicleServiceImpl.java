package com.vehicle.serviceimpl;

import com.vehicle.dto.request.VehicleDTO;
import com.vehicle.entity.Resident;
import com.vehicle.entity.Vehicle;
import com.vehicle.repository.ResidentRepository;
import com.vehicle.repository.VehicleRepository;
import com.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    ResidentRepository residentRepository;

    @Override
    public Vehicle createVehicle(VehicleDTO dto) {
        // 1. Check residence exists
        Resident residence = residentRepository.findById(dto.getResidentId())
                .orElseThrow(() -> new RuntimeException("Residence not found"));

//        // 2. Prevent duplicate registration number
//        if (vehicleRepository.existsByregistrationNumber(dto.getRegisterationNumber()      ) ){
//            throw new RuntimeException("Vehicle registration number already exists");
//        }
        // 3. Create vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setRegisterationNumber(dto.getRegisterationNumber());
        vehicle.setVehicleName(dto.getVehicleName());
        vehicle.setColor(dto.getColor());
        vehicle.setType(dto.getType());
        vehicle.setResident(residence);

        vehicle.setAssociationActivatedAt(LocalDateTime.now());
//save vehicle
        return vehicleRepository.save(vehicle);
    }
}
