package com.admin.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.admin.dto.PatientUpdateDto;
import com.admin.model.PatientDetails;
@Service
public interface PatientService {

	public List<PatientUpdateDto> findByNameByDetails(String patientName);
	
	//public List<PatientDetails> findDetails(String patientName);
	
	public PatientDetails updatePatientDetails(  PatientDetails patientDetails,Integer id);
	
	
	public List<PatientDetails> getAllPatientDetails();
	
}
