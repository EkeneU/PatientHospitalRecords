package com.example.phr.PatientHospitalRecords;

import com.example.phr.PatientHospitalRecords.SurgeryFollowUpNotes;

import java.util.List;

public interface SurgeryFollowUpNotesService {
    List<SurgeryFollowUpNotes> findAll();

    SurgeryFollowUpNotes findById(int patient_id);

    SurgeryFollowUpNotes save(SurgeryFollowUpNotes totalPatients);

    void deleteById(int patient_id);
}
