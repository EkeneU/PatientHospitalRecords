package com.example.phr.PatientHospitalRecords;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "paediatrics_follow_up_notes")
public class PaediatricsFollowUpNotes extends Paediatrics{
    @Column(name = "notes")
    private String notes;

    public PaediatricsFollowUpNotes() {
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
