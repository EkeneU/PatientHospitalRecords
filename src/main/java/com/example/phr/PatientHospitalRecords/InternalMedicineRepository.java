package com.example.phr.PatientHospitalRecords;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternalMedicineRepository extends JpaRepository<InternalMedicine, Integer> {
}
