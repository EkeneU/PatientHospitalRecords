package com.example.phr.PatientHospitalRecords;

import com.example.phr.PatientHospitalRecords.SurgeryRepository;
import com.example.phr.PatientHospitalRecords.Surgery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryServiceImpl implements SurgeryService{
    private SurgeryRepository surgeryRepository;
    @Autowired
    public SurgeryServiceImpl(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }


    @Override
    public List<Surgery> findAll() {
        return surgeryRepository.findAll();
    }

    @Override
    public Surgery findById(int patient_id) {
        Optional<Surgery> result = surgeryRepository.findById(patient_id);
        Surgery surgery;
        if (result.isPresent()){
            surgery=result.get();
        }
        else {
            throw new RuntimeException("ID not found or incompatible" + patient_id);
        }
        return surgery;
    }

    @Override
    public Surgery save(Surgery surgeryPatients) {
        return surgeryRepository.save(surgeryPatients);
    }

    @Override
    public void deleteById(int patient_id) {
        surgeryRepository.deleteById(patient_id);
    }
}
