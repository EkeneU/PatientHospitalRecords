package com.example.phr.PatientHospitalRecords.daorepo.emergency;

import com.example.phr.PatientHospitalRecords.entity.emergency.Emergency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyRepository extends JpaRepository<Emergency, Integer> {

}
