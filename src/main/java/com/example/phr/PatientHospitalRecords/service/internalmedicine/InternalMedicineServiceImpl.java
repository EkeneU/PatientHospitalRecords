package com.example.phr.PatientHospitalRecords.service.internalmedicine;

import com.example.phr.PatientHospitalRecords.daorepo.internalMedicine.InternalMedicineRepository;
import com.example.phr.PatientHospitalRecords.entity.internalmedicine.InternalMedicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternalMedicineServiceImpl implements InternalMedicineService{
    private InternalMedicineRepository internalMedicineRepository;
    @Autowired
    public InternalMedicineServiceImpl(InternalMedicineRepository internalMedicineRepository) {
        this.internalMedicineRepository = internalMedicineRepository;
    }

    @Override
    public List<InternalMedicine> findAll() {
        return internalMedicineRepository.findAll();
    }

    @Override
    public InternalMedicine findById(int patient_id) {
        Optional<InternalMedicine> result = internalMedicineRepository.findById(patient_id);
        InternalMedicine internalMedicine;
        if (result.isPresent()) {
            internalMedicine = result.get();
        }
        else {
            throw new RuntimeException("ID not found or incompatible" + patient_id);
        }
        return internalMedicine;
    }

    @Override
    public InternalMedicine save(InternalMedicine totalPatients) {
        return internalMedicineRepository.save(totalPatients);
    }

    @Override
    public void deleteById(int patient_id) {
        internalMedicineRepository.deleteById(patient_id);
    }
}
