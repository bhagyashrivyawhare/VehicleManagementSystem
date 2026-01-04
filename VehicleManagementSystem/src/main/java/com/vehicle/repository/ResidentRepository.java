package com.vehicle.repository;

import com.vehicle.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidentRepository extends JpaRepository<Resident,Integer> {
//    List<Resident> findByFName(String fName);
//
//    List<Resident> findByLName(String lName);
//
//
//    List<Resident> findByFNameAndLName(String fname, String lname);
@Query("SELECT r FROM Resident r WHERE r.fName = :fName and r.lName=:lName")
List<Resident> findByFirstName(@Param("fName") String fName, @Param("lName") String lName);
}
