package com.admin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.admin.dto.PatientUpdateDto;
import com.admin.helper.CSVHelper;
import com.admin.message.ResponseMessage;
import com.admin.model.PatientDetails;
import com.admin.services.CSVService;
import com.admin.services.PatientService;


@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping("/api/load")
public class PatientDetailsLoaderController {

  @Autowired
  CSVService fileService;
  
  @Autowired
  PatientService patientService;

  @PostMapping("/patientdata")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
    String message = "";

    if (CSVHelper.hasCSVFormat(file)) {
      try {
    	
        fileService.save(file);

        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
      } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
      }
    }

    message = "Please upload a csv file!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
  }
  
  
  @GetMapping("/retrieve/{patientName}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
  public List<PatientUpdateDto> findPatientDetails(@PathVariable String patientName)
  {
	  return  patientService.findByNameByDetails(patientName);
  }
  
  @PutMapping("/updatepatient/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public PatientDetails update(@RequestBody PatientDetails patientDetails, @PathVariable Integer id)
  {
	  return patientService.updatePatientDetails( patientDetails,id);
  }
  
  @GetMapping("/test")
  @PreAuthorize("hasRole('ADMIN')")
  public String test()
  {
	  return "only for admin";
  }
  
  @GetMapping("/testuser")
  @PreAuthorize("hasRole('USER')")
  public String testUser()
  {
	  return "only for User not for admin";
  }
  
  
  
  @GetMapping("/getAll")
  @PreAuthorize("hasRole('ADMIN')")
  public List<PatientDetails> getAllPatients()
  {
	  return patientService.getAllPatientDetails();
  }
  
  
  

//  @GetMapping("/tutorials")
//  public ResponseEntity<List<Tutorial>> getAllTutorials() {
//    try {
//      List<Tutorial> tutorials = fileService.getAllTutorials();
//
//      if (tutorials.isEmpty()) {
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//      }
//
//      return new ResponseEntity<>(tutorials, HttpStatus.OK);
//    } catch (Exception e) {
//      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }
//
//  @GetMapping("/download")
//  public ResponseEntity<Resource> getFile() {
//    String filename = "tutorials.csv";
//    InputStreamResource file = new InputStreamResource(fileService.load());
//
//    return ResponseEntity.ok()
//        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
//        .contentType(MediaType.parseMediaType("application/csv"))
//        .body(file);
//  }
//
//}

	
	
	
}
