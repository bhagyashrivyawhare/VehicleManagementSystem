package com.vehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
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

}
