package com.example.phr.PatientHospitalRecords.daorepo.emergency;

import com.example.phr.PatientHospitalRecords.entity.emergency.EmergencyFollowUpNotes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyFollowUpNotesRepository extends JpaRepository<EmergencyFollowUpNotes, Integer> {
}
