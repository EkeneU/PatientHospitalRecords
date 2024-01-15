package com.example.phr.PatientHospitalRecords.rest.paediatrics;

import com.example.phr.PatientHospitalRecords.entity.obsgynae.ObsAndGynae;
import com.example.phr.PatientHospitalRecords.entity.paediatrics.PaediatricsFollowUpNotes;
import com.example.phr.PatientHospitalRecords.service.paediatrics.PaediatricsFollowUpNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phr")
public class PaediatricsFollowUpNotesRestController {
    private PaediatricsFollowUpNotesService paediatricsFollowUpNotesService;
    @Autowired
    public PaediatricsFollowUpNotesRestController(PaediatricsFollowUpNotesService paediatricsFollowUpNotesService) {
        this.paediatricsFollowUpNotesService = paediatricsFollowUpNotesService;
    }

    @GetMapping("/pfun_patients")
    public List<PaediatricsFollowUpNotes> findAll() {
        return paediatricsFollowUpNotesService.findAll();
    }

    @GetMapping("/pfun_patients/{patient_id}")
    public PaediatricsFollowUpNotes getPatient(@PathVariable int patient_id) {
        PaediatricsFollowUpNotes patient = paediatricsFollowUpNotesService.findById(patient_id);

        if (patient==null) {
            throw new RuntimeException("Patient ID not found" + patient_id);
        }
        else {
            return patient;
        }
    }
    @PostMapping("/pfun_patient")
    public PaediatricsFollowUpNotes addNotes(@RequestBody PaediatricsFollowUpNotes paediatricsFollowUpNotes){
        paediatricsFollowUpNotes.setPatient_id(0);
        PaediatricsFollowUpNotes followUpNotes = paediatricsFollowUpNotesService.save(paediatricsFollowUpNotes);
        return followUpNotes;
    }
    @PutMapping("/pfun_patient")
    public PaediatricsFollowUpNotes updatePatientNotes(@RequestBody PaediatricsFollowUpNotes paediatricsFollowUpNotes){
        PaediatricsFollowUpNotes followUpNotes = paediatricsFollowUpNotesService.save(paediatricsFollowUpNotes);
        return followUpNotes;
    }

    @DeleteMapping("/pfun_patient/{patient_id}")
    public String deletePatient(@PathVariable int patient_id) {
        PaediatricsFollowUpNotes tempPatient = paediatricsFollowUpNotesService.findById(patient_id);

        if (tempPatient==null) {
            throw new RuntimeException("ID not recognised on the database" + patient_id);
        }
        else {
            paediatricsFollowUpNotesService.deleteById(patient_id);
            return "Patient with ID " + patient_id + " has been deleted" ;
        }
    }
}
