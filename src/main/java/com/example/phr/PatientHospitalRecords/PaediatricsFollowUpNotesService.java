package com.example.phr.PatientHospitalRecords;
import com.example.phr.PatientHospitalRecords.PaediatricsFollowUpNotes;

import java.util.List;

public interface PaediatricsFollowUpNotesService {
    List<PaediatricsFollowUpNotes> findAll();

    PaediatricsFollowUpNotes findById(int patient_id);

    PaediatricsFollowUpNotes save(PaediatricsFollowUpNotes totalPatients);

    void deleteById(int patient_id);
}
