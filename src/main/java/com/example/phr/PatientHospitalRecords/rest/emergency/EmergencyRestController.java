package com.example.phr.PatientHospitalRecords.rest.emergency;

import com.example.phr.PatientHospitalRecords.entity.emergency.Emergency;
import com.example.phr.PatientHospitalRecords.service.emergency.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TODO: Cater for global exception handling.
@RestController
@RequestMapping("/phr")
public class EmergencyRestController {
    private EmergencyService emergencyService;
    @Autowired
    public EmergencyRestController(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }

    @GetMapping("/emergency_patients")
    public List<Emergency> findAll() {
        return emergencyService.findAll();
    }
    @GetMapping("/emergency_patients/{patient_id}")
    public Emergency getPatient(@PathVariable int patient_id) {
        Emergency patient = emergencyService.findById(patient_id);

        if (patient==null) {
            throw new RuntimeException("Patient ID not found" + patient_id);
        }
        else {
            return patient;
        }
    }
    @PostMapping("/emergency_patient")
    public Emergency addPatient(@RequestBody Emergency emergency) {
        emergency.setPatient_id(0);

        Emergency dbEmergency = emergencyService.save(emergency);
        return dbEmergency;
    }
    @PutMapping("/emergency_patient")
    public Emergency updatePatient(@RequestBody Emergency emergency) {
        Emergency emergencyUpdate = emergencyService.save(emergency);
        return emergencyUpdate;
    }
    @DeleteMapping("/emergency_patient/{patient_id}")
    public String deletePatient(@PathVariable int patient_id) {
        Emergency tempPatient = emergencyService.findById(patient_id);

        if (tempPatient==null) {
            throw new RuntimeException("ID not recognised on the database" + patient_id);
        }
        else {
            emergencyService.deleteById(patient_id);
            return "Patient with ID " + patient_id + " has been deleted" ;
        }
    }
}
