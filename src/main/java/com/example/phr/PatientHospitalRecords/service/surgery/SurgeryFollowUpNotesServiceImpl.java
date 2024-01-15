package com.example.phr.PatientHospitalRecords.service.surgery;

import com.example.phr.PatientHospitalRecords.daorepo.surgery.SurgeryFollowUpNotesRepository;
import com.example.phr.PatientHospitalRecords.entity.surgery.SurgeryFollowUpNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryFollowUpNotesServiceImpl implements SurgeryFollowUpNotesService{
    private SurgeryFollowUpNotesRepository surgeryFollowUpNotesRepository;
    @Autowired
    public SurgeryFollowUpNotesServiceImpl(SurgeryFollowUpNotesRepository surgeryFollowUpNotesRepository) {
        this.surgeryFollowUpNotesRepository = surgeryFollowUpNotesRepository;
    }

    @Override
    public List<SurgeryFollowUpNotes> findAll() {
        return surgeryFollowUpNotesRepository.findAll();
    }

    @Override
    public SurgeryFollowUpNotes findById(int patient_id) {
        Optional<SurgeryFollowUpNotes> result = surgeryFollowUpNotesRepository.findById(patient_id);
        SurgeryFollowUpNotes surgeryFollowUpNotes;
        if (result.isPresent()){
            surgeryFollowUpNotes = result.get();
        }
        else {
            throw new RuntimeException("ID not found or incompatible" + patient_id);
        }
        return surgeryFollowUpNotes;
    }

    @Override
    public SurgeryFollowUpNotes save(SurgeryFollowUpNotes totalPatients) {
        return surgeryFollowUpNotesRepository.save(totalPatients);
    }

    @Override
    public void deleteById(int patient_id) {
        surgeryFollowUpNotesRepository.deleteById(patient_id);
    }
}
