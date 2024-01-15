package com.example.phr.PatientHospitalRecords.service.obsgynae;

import com.example.phr.PatientHospitalRecords.daorepo.obsgynae.ObsAndGynaeFollowUpNotesRepository;
import com.example.phr.PatientHospitalRecords.entity.obsgynae.ObsAndGynaeFollowUpNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObsAndGynaeFollowUpNotesServiceImpl implements ObsAndGynaeFollowUpNotesService{

    private ObsAndGynaeFollowUpNotesRepository obsAndGynaeFollowUpNotesRepository;
    @Autowired
    public ObsAndGynaeFollowUpNotesServiceImpl(ObsAndGynaeFollowUpNotesRepository obsAndGynaeFollowUpNotesRepository) {
        this.obsAndGynaeFollowUpNotesRepository = obsAndGynaeFollowUpNotesRepository;
    }

    @Override
    public List<ObsAndGynaeFollowUpNotes> findAll() {
        return obsAndGynaeFollowUpNotesRepository.findAll();
    }

    @Override
    public ObsAndGynaeFollowUpNotes findById(int patient_id) {
        Optional<ObsAndGynaeFollowUpNotes> result = obsAndGynaeFollowUpNotesRepository.findById(patient_id);
        ObsAndGynaeFollowUpNotes obsAndGynaeFollowUpNotes;
        if (result.isPresent()){
            obsAndGynaeFollowUpNotes = result.get();
        }
        else {
            throw new RuntimeException("ID not found" + patient_id);
        }
        return obsAndGynaeFollowUpNotes;
    }

    @Override
    public ObsAndGynaeFollowUpNotes save(ObsAndGynaeFollowUpNotes totalPatients) {
        return obsAndGynaeFollowUpNotesRepository.save(totalPatients);
    }

    @Override
    public void deleteById(int patient_id) {
        obsAndGynaeFollowUpNotesRepository.deleteById(patient_id);
    }
}
