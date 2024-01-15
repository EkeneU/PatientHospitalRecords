package com.example.phr.PatientHospitalRecords.service.obsgynae;

import com.example.phr.PatientHospitalRecords.entity.obsgynae.ObsAndGynae;

import java.util.List;

public interface ObsAndGynaeService  {

    List<ObsAndGynae> findAll();

    ObsAndGynae findById(int patient_id);

    ObsAndGynae save(ObsAndGynae totalPatients);

    void deleteById(int patient_id);
}
