package com.example.phr.PatientHospitalRecords;

import com.example.phr.PatientHospitalRecords.InternalMedicine;

import java.util.List;

public interface InternalMedicineService {
    List<InternalMedicine> findAll();

    InternalMedicine findById(int patient_id);

    InternalMedicine save(InternalMedicine totalPatients);

    void deleteById(int patient_id);
}
