package com.vehicle.contoller;

import com.vehicle.dto.request.ResidentDTO;
import com.vehicle.service.ResidentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resident")
public class ResidentController {
    @Autowired
    private ResidentService residentService;

    @PostMapping("/create")
    public ResponseEntity<String> createResident(@Valid @RequestBody ResidentDTO dto) {

        residentService.saveResident(dto);
        return ResponseEntity.ok("Resident saved with vehicle details");
    }
}



