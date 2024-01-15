package com.example.phr.PatientHospitalRecords.rest.surgery;

import com.example.phr.PatientHospitalRecords.entity.paediatrics.Paediatrics;
import com.example.phr.PatientHospitalRecords.entity.surgery.Surgery;
import com.example.phr.PatientHospitalRecords.entity.surgery.SurgeryFollowUpNotes;
import com.example.phr.PatientHospitalRecords.service.surgery.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phr")
public class SurgeryRestController {
    private SurgeryService surgeryService;
    @Autowired
    public SurgeryRestController(SurgeryService surgeryService) {
        this.surgeryService = surgeryService;
    }
    @GetMapping("/surgery_patients")
    public List<Surgery> findAll() {
        return surgeryService.findAll();
    }
    @PostMapping("/surgery_patient")
    public Surgery addPatient(@RequestBody Surgery surgery) {
        surgery.setPatient_id(0);
        Surgery dbSurgery = surgeryService.save(surgery);

        return dbSurgery;
    }

    @GetMapping("/surgery_patient/{patient_id}")
    public Surgery getPatient(@PathVariable int patient_id) {
        Surgery patient = surgeryService.findById(patient_id);

        if (patient==null) {
            throw new RuntimeException("Patient ID not found" + patient_id);
        }
        else {
            return patient;
        }
    }

//    // Adds patient from another unit.
//    @PutMapping("/surgery_patient")
//    public Surgery addPatient(@RequestBody Emergency emergency) {
//        if (emergency.getConsult().equals(Surgery.SURGERY_CONSULT_CODE)){
//            Surgery dbSurgery = surgeryService.save(new Surgery(emergency));
//            return dbSurgery;
//        }
//        else {
//            throw new RuntimeException("object not found in the database" + emergency);
//        }
//    }
    @PutMapping("/surgery_patient")
    public Surgery updateSurgery(@RequestBody Surgery surgery){
        Surgery updatedSurgery = surgeryService.save(surgery);
        return updatedSurgery;
    }

    @DeleteMapping("/surgery_patient/{patient_id}")
    public String deletePatient(@PathVariable int patient_id) {
        Surgery tempPatient = surgeryService.findById(patient_id);

        if (tempPatient==null) {
            throw new RuntimeException("ID not recognised on the database" + patient_id);
        }
        else {
            surgeryService.deleteById(patient_id);
            return "Patient with ID " + patient_id + " has been deleted" ;
        }
    }
}