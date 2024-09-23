package com.example.phr.PatientHospitalRecords;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "internal_medicine_follow_up_notes")
public class InternalMedicineFollowUpNotes extends InternalMedicine{
    @Column(name = "notes")
    private String notes;

    public InternalMedicineFollowUpNotes() {
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
