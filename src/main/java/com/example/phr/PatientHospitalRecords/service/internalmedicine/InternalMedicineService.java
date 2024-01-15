package com.example.phr.PatientHospitalRecords.service.internalmedicine;

import com.example.phr.PatientHospitalRecords.entity.internalmedicine.InternalMedicine;

import java.util.List;

public interface InternalMedicineService {
    List<InternalMedicine> findAll();

    InternalMedicine findById(int patient_id);

    InternalMedicine save(InternalMedicine totalPatients);

    void deleteById(int patient_id);
}
