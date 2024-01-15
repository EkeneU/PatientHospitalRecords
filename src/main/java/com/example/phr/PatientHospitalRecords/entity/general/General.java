package com.example.phr.PatientHospitalRecords.entity.general;

import jakarta.persistence.*;

@Entity
@Table(name = "totalpatients")
@Inheritance(strategy = InheritanceType.JOINED)
public class General {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patient_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "age")
    private int age;
    @Column(name = "sex")
    private String sex;
    @Column(name = "religion")
    private String religion;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "marital_status")
    private String marital_status;

    public General(String first_name, String last_name, int age, String sex, String religion, String occupation, String marital_status) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.sex = sex;
        this.religion = religion;
        this.occupation = occupation;
        this.marital_status = marital_status;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public General() {
    }
}
