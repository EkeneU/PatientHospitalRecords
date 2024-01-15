package com.example.phr.PatientHospitalRecords.service.surgery;

import com.example.phr.PatientHospitalRecords.entity.surgery.Surgery;

import java.util.List;

public interface SurgeryService {
    List<Surgery> findAll();

    Surgery findById(int patient_id);

    Surgery save(Surgery surgeryPatients);

    void deleteById(int patient_id);
}
