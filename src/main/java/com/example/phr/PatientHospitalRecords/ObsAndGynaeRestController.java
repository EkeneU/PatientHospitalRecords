package com.example.phr.PatientHospitalRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phr")
public class ObsAndGynaeRestController {
    private ObsAndGynaeService obsAndGynaeService;
    @Autowired
    public ObsAndGynaeRestController(ObsAndGynaeService obsAndGynaeService) {
        this.obsAndGynaeService = obsAndGynaeService;
    }

    @GetMapping("/obsgynae_patients")
    public List<ObsAndGynae> findAll() {
        return obsAndGynaeService.findAll();
    }

    @GetMapping("/obsgynae_patients/{patient_id}")
    public ObsAndGynae getPatient(@PathVariable int patient_id) {
        ObsAndGynae patient = obsAndGynaeService.findById(patient_id);

        if (patient==null) {
            throw new RuntimeException("Patient ID not found" + patient_id);
        }
        else {
            return patient;
        }
    }
    @PostMapping("/obsgynae_patient")
    public ObsAndGynae addPatient(@RequestBody ObsAndGynae obsAndGynae) {
        obsAndGynae.setPatient_id(0);

        ObsAndGynae dbObsGynae = obsAndGynaeService.save(obsAndGynae);
        return dbObsGynae;

    }

    @PutMapping("/obsgynae_patient")
    public ObsAndGynae updatePatientNotes(@RequestBody ObsAndGynae obsAndGynae){
        ObsAndGynae followUpNotes = obsAndGynaeService.save(obsAndGynae);
        return followUpNotes;
    }
    @DeleteMapping("/obsgynae_patient/{patient_id}")
    public String deletePatient(@PathVariable int patient_id) {
        ObsAndGynae tempPatient = obsAndGynaeService.findById(patient_id);

        if (tempPatient==null) {
            throw new RuntimeException("ID not recognised on the database" + patient_id);
        }
        else {
            obsAndGynaeService.deleteById(patient_id);
            return "Patient with ID " + patient_id + " has been deleted" ;
        }
    }
}
