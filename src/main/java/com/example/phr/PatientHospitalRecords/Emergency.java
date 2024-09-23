package com.example.phr.PatientHospitalRecords;

import jakarta.persistence.*;

@Entity(name = "emergency")
public class Emergency extends General {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "patient_id")
//    private int emergency_patient_id;
    public static final String EMERGENCY_CONSULT_CODE = "CONSULT FOR EMERGENCY";
    @Column(name = "presenting_complaint")
    private String presenting_complaint;
    @Column(name = "history_of_presenting_complaint")
    private String history_of_presenting_complaint;
    @Column(name = "past_medical_history")
    private String past_medical_history;
    @Column(name = "past_surgical_history")
    private String past_surgical_history;

    @Column(name = "clinical_examination")
    private String clinical_examination;
    @Column(name = "provisional_diagnosis")
    private String provisional_diagnosis;
    @Column(name = "investigations")
    private String investigations;
    @Column(name = "treatment")
    private String treatment;
    @Column(name = "consult")
    private String consult;

    public Emergency() {
    }
    public Emergency(String consult) {
        this.consult = consult;
    }

    public Emergency(String first_name, String last_name, int age, String sex, String religion, String occupation,
                     String marital_status, String presenting_complaint, String history_of_presenting_complaint,
                     String past_medical_history, String past_surgical_history, String clinical_examination,
                     String provisional_diagnosis, String investigations, String treatment, String consult) {
        super(first_name, last_name, age, sex, religion, occupation, marital_status);
        this.presenting_complaint = presenting_complaint;
        this.history_of_presenting_complaint = history_of_presenting_complaint;
        this.past_medical_history = past_medical_history;
        this.past_surgical_history = past_surgical_history;
        this.clinical_examination = clinical_examination;
        this.provisional_diagnosis = provisional_diagnosis;
        this.investigations = investigations;
        this.treatment = treatment;
        this.consult = consult;
    }

    //    public int getEmergency_patient_id() {
//        return emergency_patient_id;
//    }
//
//    public void setEmergency_patient_id(int emergency_patient_id) {
//        this.emergency_patient_id = emergency_patient_id;
//    }

    public String getPresenting_complaint() {
        return presenting_complaint;
    }

    public void setPresenting_complaint(String presenting_complaint) {
        this.presenting_complaint = presenting_complaint;
    }

    public String getHistory_of_presenting_complaint() {
        return history_of_presenting_complaint;
    }

    public void setHistory_of_presenting_complaint(String history_of_presenting_complaint) {
        this.history_of_presenting_complaint = history_of_presenting_complaint;
    }

    public String getPast_medical_history() {
        return past_medical_history;
    }

    public void setPast_medical_history(String past_medical_history) {
        this.past_medical_history = past_medical_history;
    }

    public String getPast_surgical_history() {
        return past_surgical_history;
    }

    public void setPast_surgical_history(String past_surgical_history) {
        this.past_surgical_history = past_surgical_history;
    }

    public String getClinical_examination() {
        return clinical_examination;
    }

    public void setClinical_examination(String clinical_examination) {
        this.clinical_examination = clinical_examination;
    }

    public String getProvisional_diagnosis() {
        return provisional_diagnosis;
    }

    public void setProvisional_diagnosis(String provisional_diagnosis) {
        this.provisional_diagnosis = provisional_diagnosis;
    }

    public String getInvestigations() {
        return investigations;
    }

    public void setInvestigations(String investigations) {
        this.investigations = investigations;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getConsult() {
        return consult;
    }

    public void setConsult(String consult) {
        this.consult = consult;
    }
}
