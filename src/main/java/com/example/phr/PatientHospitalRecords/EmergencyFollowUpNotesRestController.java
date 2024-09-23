package com.example.phr.PatientHospitalRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phr")
public class EmergencyFollowUpNotesRestController {
    private EmergencyFollowUpNotesService emergencyFollowUpNotesService;
    @Autowired
    public EmergencyFollowUpNotesRestController(EmergencyFollowUpNotesService emergencyFollowUpNotesService) {
        this.emergencyFollowUpNotesService = emergencyFollowUpNotesService;
    }
    @GetMapping("/efun_patients")
    public List<EmergencyFollowUpNotes> findAll() {
        return emergencyFollowUpNotesService.findAll();
    }

    @GetMapping("/efun_patients/{patient_id}")
    public EmergencyFollowUpNotes getPatient(@PathVariable int patient_id) {
        EmergencyFollowUpNotes patient = emergencyFollowUpNotesService.findById(patient_id);

        if (patient==null) {
            throw new RuntimeException("Patient ID not found" + patient_id);
        }
        else {
            return patient;
        }
    }
    @PostMapping("/efun_patient")
    public EmergencyFollowUpNotes addNotes(@RequestBody EmergencyFollowUpNotes emergencyFollowUpNotes){
        emergencyFollowUpNotes.setPatient_id(0);
        EmergencyFollowUpNotes followUpNotes = emergencyFollowUpNotesService.save(emergencyFollowUpNotes);
        return followUpNotes;
    }
    @PutMapping("/efun_patient")
    public EmergencyFollowUpNotes updatePatientNotes(@RequestBody EmergencyFollowUpNotes emergencyFollowUpNotes){
        EmergencyFollowUpNotes followUpNotes = emergencyFollowUpNotesService.save(emergencyFollowUpNotes);
        return followUpNotes;
    }
    @DeleteMapping("/efun_patient/{patient_id}")
    public String deletePatient(@PathVariable int patient_id) {
        EmergencyFollowUpNotes tempPatient = emergencyFollowUpNotesService.findById(patient_id);

        if (tempPatient==null) {
            throw new RuntimeException("ID not recognised on the database" + patient_id);
        }
        else {
            emergencyFollowUpNotesService.deleteById(patient_id);
            return "Patient with ID " + patient_id + " has been deleted" ;
        }
    }
}
