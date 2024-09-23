package com.example.phr.PatientHospitalRecords;

import com.example.phr.PatientHospitalRecords.Surgery;

import java.util.List;

public interface SurgeryService {
    List<Surgery> findAll();

    Surgery findById(int patient_id);

    Surgery save(Surgery surgeryPatients);

    void deleteById(int patient_id);
}
