package com.example.phr.PatientHospitalRecords;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalUser, Integer> {

    Optional<HospitalUser> findByEmail(String email);
}
