package com.vehicle.serviceimpl;

import com.vehicle.dto.request.ResidentDTO;
import com.vehicle.dto.request.VehicleDTO;
import com.vehicle.dto.response.ResidentResponseDTO;
import com.vehicle.dto.response.VehicleResponseDTO;
import com.vehicle.entity.Resident;
import com.vehicle.entity.Vehicle;
import com.vehicle.repository.ResidentRepository;
import com.vehicle.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResidentServiceImpl implements ResidentService {
    @Autowired
    ResidentRepository residentRepository;
    @Override
    public void saveResident(ResidentDTO dto) {
        // Create Resident object
        Resident resident = new Resident();

        // 2️ Set Resident details from DTO
        resident.setfName(dto.getfName());
        resident.setlName(dto.getlName());
        resident.setFlatNo(dto.getFlatNo());
        resident.setMobileNo(dto.getMobileNo());
        resident.setEmail(dto.getEmail());
        resident.setResident(dto.getResident());

        // 3️ Create empty vehicle list
        List<Vehicle> vehicleList = new ArrayList<>();

        // 4️ Loop through vehicle DTO list
        for (VehicleDTO vDto : dto.getVehicleDTOList()) {

            // 5 Create Vehicle object
            Vehicle vehicle = new Vehicle();

            // 6️ Set vehicle details
            vehicle.setRegisterationNumber(vDto.getRegisterationNumber());
            vehicle.setVehicleName(vDto.getVehicleName());
            vehicle.setColor(vDto.getColor());
            vehicle.setType(vDto.getType());

            // 7️ Set time from backend
            vehicle.setAssociationActivatedAt(LocalDateTime.now());

            // 8 Mark vehicle as active
            vehicle.setVehicleActive(true);

            // 9️ Link vehicle to resident
            vehicle.setResident(resident);

            // 10 Add vehicle to list
            vehicleList.add(vehicle);
        }

        //  Set vehicle list to resident
        resident.setVehicalList(vehicleList);

        // save resident (vehicles also saved automatically)
        residentRepository.save(resident);
    }
//get all resident
    @Override
    public List<ResidentResponseDTO> getAllResident() {
        List<Resident> residents=residentRepository.findAll();
        return residents.stream().map(resident ->{
            ResidentResponseDTO dto=new ResidentResponseDTO();
            dto.setId((long) resident.getId());
            dto.setFname(resident.getfName());
            dto.setEmail(resident.getEmail());
            dto.setMobileNo(String.valueOf(resident.getMobileNo()));
            List<VehicleResponseDTO> vehicleResponseDTOList= resident.getVehicalList().stream().map(vehicle ->{
                VehicleResponseDTO vehicleResponseDTO=new VehicleResponseDTO();
                vehicleResponseDTO.setVehicleId( vehicle.getVehicleId());
                vehicleResponseDTO.setVehicleName(vehicle.getVehicleName());
                vehicleResponseDTO.setRegisterationNumber(vehicle.getRegisterationNumber());
                vehicleResponseDTO.setColor(vehicle.getColor());


                return vehicleResponseDTO;
            } ).collect(Collectors.toList());
dto.setVehicles(vehicleResponseDTOList);
return dto;
        } ).collect(Collectors.toList());




    }

}

