package com.example.phr.PatientHospitalRecords.service.internalmedicine;

import com.example.phr.PatientHospitalRecords.daorepo.internalMedicine.InternalMedicineFollowUpNotesRepository;
import com.example.phr.PatientHospitalRecords.entity.internalmedicine.InternalMedicineFollowUpNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternalMedicineFollowUpNotesImpl implements InternalMedicineFollowUpNotesService{
    private InternalMedicineFollowUpNotesRepository internalMedicineFollowUpNotesRepository;
    @Autowired
    public InternalMedicineFollowUpNotesImpl(InternalMedicineFollowUpNotesRepository internalMedicineFollowUpNotesRepository) {
        this.internalMedicineFollowUpNotesRepository = internalMedicineFollowUpNotesRepository;
    }

    @Override
    public List<InternalMedicineFollowUpNotes> findAll() {
        return internalMedicineFollowUpNotesRepository.findAll();
    }

    @Override
    public InternalMedicineFollowUpNotes findById(int patient_id) {
        Optional<InternalMedicineFollowUpNotes> result = internalMedicineFollowUpNotesRepository.findById(patient_id);
        InternalMedicineFollowUpNotes internalMedicineFollowUpNotes;
        if (result.isPresent()){
            internalMedicineFollowUpNotes = result.get();
        }
        else{
            throw new RuntimeException("ID not found" + patient_id);
        }
        return internalMedicineFollowUpNotes;
    }

    @Override
    public InternalMedicineFollowUpNotes save(InternalMedicineFollowUpNotes totalPatients) {
        return internalMedicineFollowUpNotesRepository.save(totalPatients);
    }

    @Override
    public void deleteById(int patient_id) {
        internalMedicineFollowUpNotesRepository.deleteById(patient_id);

    }
}
