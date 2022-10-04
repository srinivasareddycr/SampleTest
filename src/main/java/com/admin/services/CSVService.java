package com.admin.services;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.admin.helper.CSVHelper;
import com.admin.model.PatientDetails;
import com.admin.repository.PatientDetailsRepository;


@Service
public class CSVService {
  @Autowired
  PatientDetailsRepository repository;

  public void save(MultipartFile file) throws ParseException {
    try {
    	
      List<PatientDetails> patientDetails = CSVHelper.csvToTutorials(file.getInputStream());
      
      repository.saveAll(patientDetails);
     
    } catch (IOException e) {
    	System.out.println(e.getMessage());
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
      
    }
  }

  public ByteArrayInputStream load() {
    List<PatientDetails> tutorials = repository.findAll();

    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
    return in;
  }

//  public List<PatientDetails> getAllTutorials() {
//    return repository.findAll();
//  }
}