package com.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.PatientUpdateDto;
import com.admin.exception.RecordNotFoundException;
import com.admin.model.PatientDetails;
import com.admin.repository.PatientDetailsRepository;

@Service
public class PatientDetailsImpl implements PatientService{
	
	@Autowired
	PatientDetailsRepository repository;

	@Override
	public List<PatientUpdateDto> findByNameByDetails(String patientName) {
		
		return repository.findPatientDetailsByName(patientName);
	}

	@Override
	public PatientDetails updatePatientDetails( PatientDetails patientDetails,Integer id)
	{
		PatientDetails  patients = repository.findById(id).orElseThrow(() ->
		new RecordNotFoundException("PatientDetails","id",id));
			
					patients.setAddress(patientDetails.getAddress());
					patients.setDob(patientDetails.getDob());
					patients.setEmailId(patientDetails.getEmailId());
					patients.setPhoneNumber(patientDetails.getPhoneNumber());
					repository.save(patients);
					return patients;
		}

	@Override
	public List<PatientDetails> getAllPatientDetails() {
		return repository.findAll()	;	
	}
	
	
	

}
