package com.example.phr.PatientHospitalRecords.daorepo.paediatrics;

import com.example.phr.PatientHospitalRecords.entity.paediatrics.Paediatrics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaediatricsRepository extends JpaRepository<Paediatrics, Integer> {
}
