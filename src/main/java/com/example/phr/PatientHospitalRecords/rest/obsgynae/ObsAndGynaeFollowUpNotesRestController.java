package com.example.phr.PatientHospitalRecords.rest.obsgynae;
import com.example.phr.PatientHospitalRecords.entity.internalmedicine.InternalMedicine;
import com.example.phr.PatientHospitalRecords.entity.internalmedicine.InternalMedicineFollowUpNotes;
import com.example.phr.PatientHospitalRecords.entity.obsgynae.ObsAndGynaeFollowUpNotes;
import com.example.phr.PatientHospitalRecords.service.obsgynae.ObsAndGynaeFollowUpNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phr")
public class ObsAndGynaeFollowUpNotesRestController {
    private ObsAndGynaeFollowUpNotesService obsAndGynaeFollowUpNotesService;
    @Autowired
    public ObsAndGynaeFollowUpNotesRestController(ObsAndGynaeFollowUpNotesService obsAndGynaeFollowUpNotesService) {
        this.obsAndGynaeFollowUpNotesService = obsAndGynaeFollowUpNotesService;
    }

    @GetMapping("/ogfun_patients")
    public List<ObsAndGynaeFollowUpNotes> findAll() {
        return obsAndGynaeFollowUpNotesService.findAll();
    }

    @GetMapping("/ogfun_patients/{patient_id}")
    public ObsAndGynaeFollowUpNotes getPatient(@PathVariable int patient_id) {
        ObsAndGynaeFollowUpNotes patient = obsAndGynaeFollowUpNotesService.findById(patient_id);

        if (patient==null) {
            throw new RuntimeException("Patient ID not found" + patient_id);
        }
        else {
            return patient;
        }
    }
    @PostMapping("/ogfun_patient")
    public ObsAndGynaeFollowUpNotes addNotes(@RequestBody ObsAndGynaeFollowUpNotes obsAndGynaeFollowUpNotes){
        obsAndGynaeFollowUpNotes.setPatient_id(0);
        ObsAndGynaeFollowUpNotes followUpNotes = obsAndGynaeFollowUpNotesService.save(obsAndGynaeFollowUpNotes);
        return followUpNotes;
    }
    @PutMapping("/ogfun_patient")
    public ObsAndGynaeFollowUpNotes updatePatientNotes(@RequestBody ObsAndGynaeFollowUpNotes obsAndGynaeFollowUpNotes){
        ObsAndGynaeFollowUpNotes followUpNotes = obsAndGynaeFollowUpNotesService.save(obsAndGynaeFollowUpNotes);
        return followUpNotes;
    }
    @DeleteMapping("/ogfun_patient/{patient_id}")
    public String deletePatient(@PathVariable int patient_id) {
        ObsAndGynaeFollowUpNotes tempPatient = obsAndGynaeFollowUpNotesService.findById(patient_id);

        if (tempPatient==null) {
            throw new RuntimeException("ID not recognised on the database" + patient_id);
        }
        else {
            obsAndGynaeFollowUpNotesService.deleteById(patient_id);
            return "Patient with ID " + patient_id + " has been deleted" ;
        }
    }
}