package com.vehicle.service;

import com.vehicle.dto.request.ResidentDTO;
import com.vehicle.dto.response.ResidentResponseDTO;
import com.vehicle.entity.Resident;
import com.vehicle.exception.ResidentNotFoundException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResidentService {
    public void saveResident(ResidentDTO dto);
    //get all resident
    List<ResidentResponseDTO> getAllResident();
    List<Resident> getResidentByName(String f_name,String l_name) throws ResidentNotFoundException;
}
