package com.example.phr.PatientHospitalRecords;

import com.example.phr.PatientHospitalRecords.ObsAndGynaeFollowUpNotes;

import java.util.List;

public interface ObsAndGynaeFollowUpNotesService {
    List<ObsAndGynaeFollowUpNotes> findAll();

    ObsAndGynaeFollowUpNotes findById(int patient_id);

    ObsAndGynaeFollowUpNotes save(ObsAndGynaeFollowUpNotes totalPatients);

    void deleteById(int patient_id);
}
