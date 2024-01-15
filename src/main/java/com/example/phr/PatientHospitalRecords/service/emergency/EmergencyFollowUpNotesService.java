package com.example.phr.PatientHospitalRecords.service.emergency;

import com.example.phr.PatientHospitalRecords.entity.emergency.EmergencyFollowUpNotes;

import java.util.List;

public interface EmergencyFollowUpNotesService {

    List<EmergencyFollowUpNotes> findAll();

    EmergencyFollowUpNotes findById(int patient_id);

    EmergencyFollowUpNotes save(EmergencyFollowUpNotes totalPatients);

    void deleteById(int patient_id);
}
