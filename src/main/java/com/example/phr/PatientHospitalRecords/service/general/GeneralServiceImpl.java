package com.example.phr.PatientHospitalRecords.service.general;

import com.example.phr.PatientHospitalRecords.daorepo.general.GeneralRepository;
import com.example.phr.PatientHospitalRecords.entity.general.General;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GeneralServiceImpl implements GeneralService {
     private GeneralRepository generalRepository;
    @Autowired
    public GeneralServiceImpl(GeneralRepository generalRepository) {
        this.generalRepository = generalRepository;
    }

    @Override
    public List<General> findAll() {
        return generalRepository.findAll();
    }

    @Override
    public General findById(int patient_id) {
        Optional<General> result = generalRepository.findById(patient_id);
        General general = new General();
        if (result.isPresent()) {
            general = result.get();
        }
        else {
            throw new RuntimeException("ID not found or incompatible" + patient_id);
        }
        return general;
    }

    @Override
    public General save(General totalPatients) {
        return generalRepository.save(totalPatients);
    }

    @Override
    public void deleteById(int patient_id) {
        generalRepository.deleteById(patient_id);
    }
}
