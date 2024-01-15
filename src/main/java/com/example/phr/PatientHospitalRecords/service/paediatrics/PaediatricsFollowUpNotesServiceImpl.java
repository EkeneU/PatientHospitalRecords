package com.example.phr.PatientHospitalRecords.service.paediatrics;

import com.example.phr.PatientHospitalRecords.daorepo.paediatrics.PaediatricsFollowUpNotesRepository;
import com.example.phr.PatientHospitalRecords.entity.paediatrics.PaediatricsFollowUpNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaediatricsFollowUpNotesServiceImpl implements PaediatricsFollowUpNotesService{

    private PaediatricsFollowUpNotesRepository paediatricsFollowUpNotesRepository;
    @Autowired
    public PaediatricsFollowUpNotesServiceImpl(PaediatricsFollowUpNotesRepository paediatricsFollowUpNotesRepository) {
        this.paediatricsFollowUpNotesRepository = paediatricsFollowUpNotesRepository;
    }

    @Override
    public List<PaediatricsFollowUpNotes> findAll() {
        return paediatricsFollowUpNotesRepository.findAll();
    }

    @Override
    public PaediatricsFollowUpNotes findById(int patient_id) {
        Optional<PaediatricsFollowUpNotes> result = paediatricsFollowUpNotesRepository.findById(patient_id);
        PaediatricsFollowUpNotes paediatricsFollowUpNotes;
        if (result.isPresent()){
            paediatricsFollowUpNotes = result.get();
        }
        else {
            throw new RuntimeException("ID not found " + patient_id);
        }
        return paediatricsFollowUpNotes;
    }

    @Override
    public PaediatricsFollowUpNotes save(PaediatricsFollowUpNotes totalPatients) {
        return paediatricsFollowUpNotesRepository.save(totalPatients);
    }

    @Override
    public void deleteById(int patient_id) {
        paediatricsFollowUpNotesRepository.deleteById(patient_id);
    }
}
