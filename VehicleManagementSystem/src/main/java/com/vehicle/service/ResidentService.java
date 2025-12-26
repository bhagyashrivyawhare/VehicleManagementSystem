package com.vehicle.service;

import com.vehicle.dto.request.ResidentDTO;
import com.vehicle.dto.response.ResidentResponseDTO;
import com.vehicle.entity.Resident;

import java.util.List;

public interface ResidentService {
    public void saveResident(ResidentDTO dto);
    //get all resident
    List<ResidentResponseDTO> getAllResident();
    public List<Resident> findResidentByName(String firstName, String lastName);
}
