package com.example.phr.PatientHospitalRecords.service.general;

import com.example.phr.PatientHospitalRecords.entity.general.General;

import java.util.List;

public interface GeneralService {

    List<General> findAll();

    General findById(int theId);

    General save(General totalPatients);

    void deleteById(int patient_id);
}
