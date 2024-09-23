package com.example.phr.PatientHospitalRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phr")
public class InternalMedicineFollowUpNotesRestController {
    private InternalMedicineFollowUpNotesService internalMedicineFollowUpNotesService;
    @Autowired
    public InternalMedicineFollowUpNotesRestController(InternalMedicineFollowUpNotesService internalMedicineFollowUpNotesService) {
        this.internalMedicineFollowUpNotesService = internalMedicineFollowUpNotesService;
    }

    @GetMapping("/imfun_patients")
    public List<InternalMedicineFollowUpNotes> findAll() {
        return internalMedicineFollowUpNotesService.findAll();
    }

    @GetMapping("/imfun_patients/{patient_id}")
    public InternalMedicineFollowUpNotes getPatient(@PathVariable int patient_id) {
        InternalMedicineFollowUpNotes patient = internalMedicineFollowUpNotesService.findById(patient_id);

        if (patient==null) {
            throw new RuntimeException("Patient ID not found" + patient_id);
        }
        else {
            return patient;
        }
    }
    @PostMapping("/imfun_patient")
    public InternalMedicineFollowUpNotes addNotes(@RequestBody InternalMedicineFollowUpNotes internalMedicineFollowUpNotes){
        internalMedicineFollowUpNotes.setPatient_id(0);
        InternalMedicineFollowUpNotes followUpNotes = internalMedicineFollowUpNotesService.save(internalMedicineFollowUpNotes);
        return followUpNotes;
    }
    @PutMapping("/imfun_patient")
    public InternalMedicineFollowUpNotes updatePatientNotes(@RequestBody InternalMedicineFollowUpNotes internalMedicineFollowUpNotes){
        InternalMedicineFollowUpNotes followUpNotes = internalMedicineFollowUpNotesService.save(internalMedicineFollowUpNotes);
        return followUpNotes;
    }
    @DeleteMapping("/imfun_patient/{patient_id}")
    public String deletePatient(@PathVariable int patient_id) {
        InternalMedicineFollowUpNotes tempPatient = internalMedicineFollowUpNotesService.findById(patient_id);

        if (tempPatient==null) {
            throw new RuntimeException("ID not recognised on the database" + patient_id);
        }
        else {
            internalMedicineFollowUpNotesService.deleteById(patient_id);
            return "Patient with ID " + patient_id + " has been deleted" ;
        }
    }
}
