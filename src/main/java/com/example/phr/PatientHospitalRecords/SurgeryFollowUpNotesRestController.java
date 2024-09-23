package com.example.phr.PatientHospitalRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phr")
public class SurgeryFollowUpNotesRestController {
    private SurgeryFollowUpNotesService service;
    @Autowired
    public SurgeryFollowUpNotesRestController(SurgeryFollowUpNotesService service) {
        this.service = service;
    }
    @GetMapping("/sfun_patients")
    public List<SurgeryFollowUpNotes> findAll() {
        return service.findAll();
    }

    @GetMapping("/sfun_patients/{patient_id}")
    public SurgeryFollowUpNotes getPatient(@PathVariable int patient_id) {
        SurgeryFollowUpNotes patient = service.findById(patient_id);

        if (patient==null) {
            throw new RuntimeException("Patient ID not found" + patient_id);
        }
        else {
            return patient;
        }
    }
    @PostMapping("/sfun_patient")
    public SurgeryFollowUpNotes addNotes(@RequestBody SurgeryFollowUpNotes surgeryFollowUpNotes){
        surgeryFollowUpNotes.setPatient_id(0);
        SurgeryFollowUpNotes followUpNotes = service.save(surgeryFollowUpNotes);
        return followUpNotes;
    }
    @PutMapping("/sfun_patient")
    public SurgeryFollowUpNotes updatePatientNotes(@RequestBody SurgeryFollowUpNotes surgeryFollowUpNotes){
        SurgeryFollowUpNotes followUpNotes = service.save(surgeryFollowUpNotes);
        return followUpNotes;
    }
    @DeleteMapping("/sfun_patient/{patient_id}")
    public String deletePatient(@PathVariable int patient_id) {
        SurgeryFollowUpNotes tempPatient = service.findById(patient_id);

        if (tempPatient==null) {
            throw new RuntimeException("ID not recognised on the database" + patient_id);
        }
        else {
            service.deleteById(patient_id);
            return "Patient with ID " + patient_id + " has been deleted" ;
        }
    }
}
