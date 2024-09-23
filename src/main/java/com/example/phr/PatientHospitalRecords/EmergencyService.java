package com.example.phr.PatientHospitalRecords;

import com.example.phr.PatientHospitalRecords.Emergency;

import java.util.List;

public interface EmergencyService {

    List<Emergency> findAll();

    Emergency findById(int patient_id);

    Emergency save(Emergency totalPatients);

    void deleteById(int patient_id);
}
