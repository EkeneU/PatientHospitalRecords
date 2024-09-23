package com.example.phr.PatientHospitalRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phr")
public class PaediatricsRestController {
    private PaediatricsService paediatricsService;
    @Autowired
    public PaediatricsRestController(PaediatricsService paediatricsService) {
        this.paediatricsService = paediatricsService;
    }
    @GetMapping("/paediatrics_patients")
    public List<Paediatrics> findAll() {
        return paediatricsService.findAll();
    }

    @GetMapping("/paediatrics_patients/{patient_id}")
    public Paediatrics getPatient(@PathVariable int patient_id) {
        Paediatrics patient = paediatricsService.findById(patient_id);

        if (patient==null) {
            throw new RuntimeException("Patient ID not found" + patient_id);
        }
        else {
            return patient;
        }
    }
    @PostMapping("/paediatrics_patient")
    public Paediatrics addPatient(@RequestBody Paediatrics paedsPatient) {
        paedsPatient.setPatient_id(0);
        Paediatrics paeds = paediatricsService.save(paedsPatient);
        return paeds;
    }

    @PutMapping("/paediatrics_patient")
    public Paediatrics updatePatientNotes(@RequestBody Paediatrics paediatrics){
        Paediatrics followUpNotes = paediatricsService.save(paediatrics);
        return followUpNotes;
    }

    @DeleteMapping("/paediatrics_patient/{patient_id}")
    public String deletePatient(@PathVariable int patient_id) {
        Paediatrics tempPatient = paediatricsService.findById(patient_id);

        if (tempPatient==null) {
            throw new RuntimeException("ID not recognised on the database" + patient_id);
        }
        else {
            paediatricsService.deleteById(patient_id);
            return "Patient with ID " + patient_id + " has been deleted" ;
        }
    }
}
