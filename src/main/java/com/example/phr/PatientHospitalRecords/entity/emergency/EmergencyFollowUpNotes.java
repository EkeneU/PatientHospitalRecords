package com.example.phr.PatientHospitalRecords.entity.emergency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "emergency_follow_up_notes")
public class EmergencyFollowUpNotes extends Emergency{
    @Column(name = "notes")
    private String notes;

    public EmergencyFollowUpNotes() {
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
