package com.vehicle.contoller;

import com.vehicle.dto.request.ResidentDTO;
import com.vehicle.dto.response.ResidentResponseDTO;
import com.vehicle.service.ResidentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getAllResident")
    public ResponseEntity<List<ResidentResponseDTO>> getAllResident(){
        List<ResidentResponseDTO> listAll=residentService.getAllResident();
        return new ResponseEntity<>(listAll, HttpStatus.FOUND);
    }
}



