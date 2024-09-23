package com.example.phr.PatientHospitalRecords;

import com.example.phr.PatientHospitalRecords.General;

import java.util.List;

public interface GeneralService {

    List<General> findAll();

    General findById(int theId);

    General save(General totalPatients);

    void deleteById(int patient_id);
}
