package com.example.phr.PatientHospitalRecords;

import com.example.phr.PatientHospitalRecords.Paediatrics;

import java.util.List;

public interface PaediatricsService {
    List<Paediatrics> findAll();

    Paediatrics findById(int patient_id);

    Paediatrics save(Paediatrics totalPatients);

    void deleteById(int patient_id);
}
