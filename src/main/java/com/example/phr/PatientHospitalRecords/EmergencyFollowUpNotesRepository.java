package com.example.phr.PatientHospitalRecords;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyFollowUpNotesRepository extends JpaRepository<EmergencyFollowUpNotes, Integer> {
}
