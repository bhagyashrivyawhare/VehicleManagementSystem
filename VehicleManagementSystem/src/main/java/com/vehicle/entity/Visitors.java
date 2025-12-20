package com.vehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Visitors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

   private int visitorId;

   private String  visitorName;
    private String vehicleName;
   private String VehicalRegisterationNumber;

   private String  visitPurpose	;
    private LocalDateTime timeIn;
    private  LocalDateTime  timeOut;
   private Long phoneNumber	;
    private  boolean isActiveVisitor;
    @Enumerated(EnumType.STRING)
    private Visotortype visotortype;
    public enum  Visotortype{
        GUEST,DELIVERY

    }


}
