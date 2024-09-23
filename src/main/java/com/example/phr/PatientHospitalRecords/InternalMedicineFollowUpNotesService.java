package com.example.phr.PatientHospitalRecords;

import com.example.phr.PatientHospitalRecords.InternalMedicineFollowUpNotes;

import java.util.List;

public interface InternalMedicineFollowUpNotesService {
    List<InternalMedicineFollowUpNotes> findAll();

    InternalMedicineFollowUpNotes findById(int patient_id);

    InternalMedicineFollowUpNotes save(InternalMedicineFollowUpNotes totalPatients);

    void deleteById(int patient_id);
}
