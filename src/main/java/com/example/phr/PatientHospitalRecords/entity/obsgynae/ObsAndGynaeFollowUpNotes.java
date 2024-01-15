package com.example.phr.PatientHospitalRecords.entity.obsgynae;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "obsandgynae_follow_up_notes")
public class ObsAndGynaeFollowUpNotes extends ObsAndGynae{
    @Column(name = "notes")
    private String notes;

    public ObsAndGynaeFollowUpNotes() {
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
