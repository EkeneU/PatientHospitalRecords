package com.example.phr.PatientHospitalRecords.service.emergency;

import com.example.phr.PatientHospitalRecords.entity.emergency.Emergency;

import java.util.List;

public interface EmergencyService {

    List<Emergency> findAll();

    Emergency findById(int patient_id);

    Emergency save(Emergency totalPatients);

    void deleteById(int patient_id);
}
