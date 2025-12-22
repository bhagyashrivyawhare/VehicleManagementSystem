package com.vehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Setter
@Getter
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(nullable = false)
    private String fName;


    private String lName;
    @NotNull
    @Column(nullable = false)
    private String flatNo;
    @NotNull
    @Column(nullable = false)
    private long mobileNo;
    @NotNull
    @Column(nullable = false)
    private String email;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ResidentType resident;
    public enum ResidentType{
        TENANT,OWNER
    }
    @OneToMany(mappedBy = "resident", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vehicle> vehicalList;

    @OneToMany(mappedBy = "resident", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Visitors> visitorList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ResidentType getResident() {
        return resident;
    }

    public void setResident(ResidentType resident) {
        this.resident = resident;
    }

    public List<Vehicle> getVehicalList() {
        return vehicalList;
    }

    public void setVehicalList(List<Vehicle> vehicleList) {
        this.vehicalList = vehicleList;
    }

    public List<Visitors> getVisitorList() {
        return visitorList;
    }

    public void setVisitorList(List<Visitors> visitorList) {
        this.visitorList = visitorList;
    }
}
