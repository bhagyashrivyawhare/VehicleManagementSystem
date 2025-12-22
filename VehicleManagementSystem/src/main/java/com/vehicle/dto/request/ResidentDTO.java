package com.vehicle.dto.request;

import com.vehicle.entity.Resident;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class ResidentDTO {

   // @NotBlank(message = "First name is required")
    private String fName;

    private String lName;

    @NotBlank(message = "Flat number is required")
    private String flatNo;

    @NotNull(message = "Mobile number is required")
    private Long mobileNo;

    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Resident type is required")
    private Resident.ResidentType resident;

    @NotEmpty(message = "At least one vehicle is required")
    @Valid
    private List<VehicleDTO> vehicleDTOList;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Resident.ResidentType getResident() {
        return resident;
    }

    public void setResident(Resident.ResidentType resident) {
        this.resident = resident;
    }

    public List<VehicleDTO> getVehicleDTOList() {
        return vehicleDTOList;
    }

    public void setVehicleDTOList(List<VehicleDTO> vehicleDTOList) {
        this.vehicleDTOList = vehicleDTOList;
    }
}
