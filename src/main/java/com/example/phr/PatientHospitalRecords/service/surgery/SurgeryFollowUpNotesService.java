package com.example.phr.PatientHospitalRecords.service.surgery;

import com.example.phr.PatientHospitalRecords.entity.surgery.SurgeryFollowUpNotes;

import java.util.List;

public interface SurgeryFollowUpNotesService {
    List<SurgeryFollowUpNotes> findAll();

    SurgeryFollowUpNotes findById(int patient_id);

    SurgeryFollowUpNotes save(SurgeryFollowUpNotes totalPatients);

    void deleteById(int patient_id);
}
