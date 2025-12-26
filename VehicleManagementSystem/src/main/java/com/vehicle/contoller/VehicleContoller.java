package com.vehicle.contoller;

import com.vehicle.dto.request.VehicleDTO;
import com.vehicle.entity.Vehicle;
import com.vehicle.repository.VehicleRepository;
import com.vehicle.service.ResidentService;
import com.vehicle.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleContoller {
    @Autowired
    VehicleService vehicleService;

    @PostMapping("/create")
    public ResponseEntity<Vehicle> createVehicle(@Valid @RequestBody VehicleDTO dto){
        Vehicle saveVehicle=vehicleService.createVehicle(dto);
        return new ResponseEntity<>(saveVehicle, HttpStatus.CREATED);
    }
}
