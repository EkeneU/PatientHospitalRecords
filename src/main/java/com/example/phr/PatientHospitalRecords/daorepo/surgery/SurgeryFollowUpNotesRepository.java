package com.example.phr.PatientHospitalRecords.daorepo.surgery;

import com.example.phr.PatientHospitalRecords.entity.surgery.SurgeryFollowUpNotes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryFollowUpNotesRepository extends JpaRepository<SurgeryFollowUpNotes, Integer> {
}
