package com.example.phr.PatientHospitalRecords.daorepo.surgery;

import com.example.phr.PatientHospitalRecords.entity.surgery.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {

}
