package com.example.phr.PatientHospitalRecords.service.paediatrics;

import com.example.phr.PatientHospitalRecords.daorepo.paediatrics.PaediatricsRepository;
import com.example.phr.PatientHospitalRecords.entity.paediatrics.Paediatrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaediatricsServiceImpl implements PaediatricsService{

    private PaediatricsRepository paediatricsRepository;
    @Autowired
    public PaediatricsServiceImpl(PaediatricsRepository paediatricsRepository) {
        this.paediatricsRepository = paediatricsRepository;
    }

    @Override
    public List<Paediatrics> findAll() {
        return paediatricsRepository.findAll();
    }

    @Override
    public Paediatrics findById(int patient_id) {
        Optional<Paediatrics> result = paediatricsRepository.findById(patient_id);
        Paediatrics paediatrics;
        if (result.isPresent()){
            paediatrics=result.get();
        }
        else {
            throw new RuntimeException("ID not found or incompatible" + patient_id);
        }
        return paediatrics;
    }

    @Override
    public Paediatrics save(Paediatrics totalPatients) {
        return paediatricsRepository.save(totalPatients);
    }

    @Override
    public void deleteById(int patient_id) {
        paediatricsRepository.deleteById(patient_id);
    }
}
