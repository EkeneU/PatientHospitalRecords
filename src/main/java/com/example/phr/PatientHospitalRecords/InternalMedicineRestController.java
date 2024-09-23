package com.example.phr.PatientHospitalRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phr")
public class InternalMedicineRestController {
    private InternalMedicineService internalMedicineService;
    @Autowired
    public InternalMedicineRestController(InternalMedicineService internalMedicineService) {
        this.internalMedicineService = internalMedicineService;
    }
    @GetMapping("/im_patients")
    public List<InternalMedicine> findAll(){
        return internalMedicineService.findAll();
    }

    @GetMapping("/im_patients/{patient_id}")
    public InternalMedicine getPatient(@PathVariable int patient_id) {
        InternalMedicine patient = internalMedicineService.findById(patient_id);

        if (patient==null) {
            throw new RuntimeException("Patient ID not found" + patient_id);
        }
        else {
            return patient;
        }
    }
    @PostMapping("/im_patient")
    public InternalMedicine addPatient(@RequestBody InternalMedicine internalMedicine){
        internalMedicine.setPatient_id(0);
        InternalMedicine medicine =internalMedicineService.save(internalMedicine);
        return medicine;
    }

    @PutMapping("/im_patient")
    public InternalMedicine updatePatient(@RequestBody InternalMedicine internalMedicine) {
       InternalMedicine  imUpdate = internalMedicineService.save(internalMedicine);
        return imUpdate;
    }
    @DeleteMapping("/im_patient/{patient_id}")
    public String deletePatient(@PathVariable int patient_id) {
        InternalMedicine tempPatient = internalMedicineService.findById(patient_id);

        if (tempPatient==null) {
            throw new RuntimeException("ID not recognised on the database" + patient_id);
        }
        else {
            internalMedicineService.deleteById(patient_id);
            return "Patient with ID " + patient_id + " has been deleted" ;
        }
    }
}
