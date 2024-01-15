package com.example.phr.PatientHospitalRecords.daorepo.internalMedicine;

import com.example.phr.PatientHospitalRecords.entity.internalmedicine.InternalMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternalMedicineRepository extends JpaRepository<InternalMedicine, Integer> {
}
