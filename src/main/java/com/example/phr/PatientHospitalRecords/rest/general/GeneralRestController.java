package com.example.phr.PatientHospitalRecords.rest.general;

import com.example.phr.PatientHospitalRecords.entity.emergency.Emergency;
import com.example.phr.PatientHospitalRecords.entity.general.General;
import com.example.phr.PatientHospitalRecords.service.general.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phr")
public class GeneralRestController {
    private GeneralService generalService;
    @Autowired
    public GeneralRestController(GeneralService generalService) {
        this.generalService = generalService;
    }
    @GetMapping("/general_patients")
    public List<General> findAll(){
        return generalService.findAll();
    }

    @GetMapping("/general_patients/{patient_id}")
    public General getPatient(@PathVariable int patient_id) {
        General patient = generalService.findById(patient_id);

        if (patient==null) {
            throw new RuntimeException("Patient ID not found" + patient_id);
        }
        else {
            return patient;
        }
    }
    @PostMapping("/general_patient")
    public General addPatient (@RequestBody General general) {
        general.setPatient_id(0);

        General dbGeneral = generalService.save(general);
        return dbGeneral;
    }
    @DeleteMapping("/general_patient/{patient_id}")
    public String deletePatient(@PathVariable int patient_id) {
        General tempPatient = generalService.findById(patient_id);

        if (tempPatient==null) {
            throw new RuntimeException("ID not recognised on the database" + patient_id);
        }
        else {
            generalService.deleteById(patient_id);
            return "Patient with ID " + patient_id + " has been deleted" ;
        }
    }
}
