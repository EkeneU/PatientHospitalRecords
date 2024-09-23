package com.example.phr.PatientHospitalRecords;

import com.example.phr.PatientHospitalRecords.EmergencyRepository;
import com.example.phr.PatientHospitalRecords.Emergency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmergencyServiceImpl implements EmergencyService{
    private EmergencyRepository emergencyRepository;

    @Autowired
    public EmergencyServiceImpl(EmergencyRepository emergencyRepository) {
        this.emergencyRepository = emergencyRepository;
    }

    @Override
    public List<Emergency> findAll() {
        return emergencyRepository.findAll();
    }

    @Override
    public Emergency findById(int patient_id) {
        Optional<Emergency> result = emergencyRepository.findById(patient_id);
        Emergency emergency;
        if (result.isPresent()) {
            emergency = result.get();
        }
        else {
            throw new RuntimeException("ID not found or incompatible" + patient_id);
        }
        return emergency;
    }

    @Override
    public Emergency save(Emergency totalPatients) {
        return emergencyRepository.save(totalPatients);
    }

    @Override
    public void deleteById(int patient_id) {
        emergencyRepository.deleteById(patient_id);
    }
}
