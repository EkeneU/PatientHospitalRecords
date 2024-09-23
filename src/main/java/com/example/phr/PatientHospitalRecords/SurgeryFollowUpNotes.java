package com.example.phr.PatientHospitalRecords;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "surgery_follow_up_notes")
public class SurgeryFollowUpNotes extends Surgery{
    @Column(name = "notes")
    private String notes;

    public SurgeryFollowUpNotes() {
    }


    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
