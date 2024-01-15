package com.example.phr.PatientHospitalRecords.service.emergency;

import com.example.phr.PatientHospitalRecords.daorepo.emergency.EmergencyFollowUpNotesRepository;
import com.example.phr.PatientHospitalRecords.entity.emergency.EmergencyFollowUpNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmergencyFollowUpNotesServiceImpl implements EmergencyFollowUpNotesService{
    private EmergencyFollowUpNotesRepository emergencyFollowUpNotesRepository;
    @Autowired
    public EmergencyFollowUpNotesServiceImpl(EmergencyFollowUpNotesRepository emergencyFollowUpNotesRepository) {
        this.emergencyFollowUpNotesRepository = emergencyFollowUpNotesRepository;
    }

    @Override
    public List<EmergencyFollowUpNotes> findAll() {
        return emergencyFollowUpNotesRepository.findAll();
    }

    @Override
    public EmergencyFollowUpNotes findById(int patient_id) {
        Optional<EmergencyFollowUpNotes> result = emergencyFollowUpNotesRepository.findById(patient_id);
        EmergencyFollowUpNotes emergencyFollowUpNotes;
        if (result.isPresent()){
            emergencyFollowUpNotes = result.get();
        }
        else {
            throw new RuntimeException("Id not found " + patient_id);
        }
        return null;
    }

    @Override
    public EmergencyFollowUpNotes save(EmergencyFollowUpNotes totalPatients) {
        return emergencyFollowUpNotesRepository.save(totalPatients);
    }

    @Override
    public void deleteById(int patient_id) {
        emergencyFollowUpNotesRepository.deleteById(patient_id);
    }
}
