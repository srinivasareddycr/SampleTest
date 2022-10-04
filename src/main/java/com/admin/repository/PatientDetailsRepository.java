package com.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.admin.dto.PatientUpdateDto;
import com.admin.model.PatientDetails;

@Repository
public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Integer> {
	
	@Query(nativeQuery = true)
	   public List<PatientUpdateDto> findPatientDetailsByName(String  patientName);
	
	
		//public PatientDetails findByPatientName(String patientName);
	

}
