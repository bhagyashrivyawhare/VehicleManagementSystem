package com.vehicle.repository;

import com.vehicle.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidentRepository extends JpaRepository<Resident,Integer> {
    List<Resident> findByFName(String fName);

    List<Resident> findByLName(String lName);


    List<Resident> findByFNameAndLName(String fname, String lname);
}
