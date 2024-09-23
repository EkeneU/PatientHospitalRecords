package com.example.phr.PatientHospitalRecords;

import com.example.phr.PatientHospitalRecords.ObsAndGynaeRepository;
import com.example.phr.PatientHospitalRecords.ObsAndGynae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObsAndGynaeServiceImpl implements ObsAndGynaeService {

    private ObsAndGynaeRepository obsAndGynaeRepository;
    @Autowired
    public ObsAndGynaeServiceImpl(ObsAndGynaeRepository obsAndGynaeRepository) {
        this.obsAndGynaeRepository = obsAndGynaeRepository;
    }

    @Override
    public List<ObsAndGynae> findAll() {
        return obsAndGynaeRepository.findAll();
    }

    @Override
    public ObsAndGynae findById(int patient_id) {
        Optional<ObsAndGynae> result = obsAndGynaeRepository.findById(patient_id);
        ObsAndGynae obsAndGynae;
        if (result.isPresent()){
            obsAndGynae=result.get();
        }
        else {
            throw new RuntimeException("ID not found or incompatible" + patient_id);
        }
        return obsAndGynae;
    }

    @Override
    public ObsAndGynae save(ObsAndGynae o_gPatients) {
        return obsAndGynaeRepository.save(o_gPatients);
    }

    @Override
    public void deleteById(int patient_id) {
         obsAndGynaeRepository.deleteById(patient_id);
    }
}
