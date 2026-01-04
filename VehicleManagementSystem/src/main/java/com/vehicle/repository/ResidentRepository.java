package com.vehicle.repository;

import com.vehicle.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Query("""
           SELECT r
           FROM Resident r
           JOIN r.vehicalList v
           WHERE v.registerationNumber = :regNo
           """)
    Optional<Resident> findByRegistrationNo(@Param("regNo") String regNo);
}