package com.example.phr.PatientHospitalRecords;

import com.example.phr.PatientHospitalRecords.ObsAndGynae;

import java.util.List;

public interface ObsAndGynaeService  {

    List<ObsAndGynae> findAll();

    ObsAndGynae findById(int patient_id);

    ObsAndGynae save(ObsAndGynae totalPatients);

    void deleteById(int patient_id);
}
