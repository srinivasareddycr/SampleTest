package com.admin.helper;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import com.admin.model.PatientDetails;



public class CSVHelper {
	
	
	
	
  public static String TYPE = "text/csv";
  static String[] HEADERs = {  "address", "dob", "drugId","drugName","emailId","patientName","phoneNumber" };

  public static boolean hasCSVFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
    	
      return false;
    }

    return true;
  }

  public static List<PatientDetails> csvToTutorials(InputStream is) throws ParseException {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
    		
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
    
      List<PatientDetails> patientDetails = new ArrayList<PatientDetails>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
    	  PatientDetails tutorial = new PatientDetails(
             // Integer.parseInt(csvRecord.get("id")),
    			 
              csvRecord.get("address"),
              csvRecord.get("dob"),
              csvRecord.get("drugId"),
              csvRecord.get("drugName"),
              csvRecord.get("emailId"),
              csvRecord.get("patientName"),
              csvRecord.get("phoneNumber")
              
              
            );
    	  
    	 

    	  patientDetails.add(tutorial); 
    	 
     
      }
      boolean status =false;
      List<PatientDetails> list = new ArrayList<PatientDetails>();
      List<PatientDetails> failedList = new ArrayList<PatientDetails>();
   
      for(int i=0;i<patientDetails.size();i++)
	  {
    	  status=false;
    	  
		  if((patientDetails.get(i).getPatientName().length()>=5&&patientDetails.get(i).getPatientName().length()<=30)&&(patientDetails.get(i).getPhoneNumber().length()==10))
		  
		  {
			  if((patientDetails.get(i).getDrugId().matches(("[0-9]{5}[-]{1}[0-9]{4}[-]{1}[0-9]{2}")))&&(patientDetails.get(i).getEmailId().contains("@")))
			  {
				  SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				  String checkdate = patientDetails.get(i).getDob();
				  Date cc = format.parse(checkdate);
				  
				  System.out.println(cc);
				  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
				  LocalDateTime now = LocalDateTime.now(); 
				  String currentDate= dtf.format(now);
				  Date CurDate= format.parse(currentDate);
				  System.out.println(currentDate);
				
				  if(cc.before(CurDate)&&checkdate.matches("[0-9]{2}[-]{1}[0-9]{2}[-]{1}[0-9]{4}"))
				  {
				  status=true;
				  
				  list.add(patientDetails.get(i));
				  }
			  }
		  }
		  else
		  {
			  
			 
			 System.out.println("!!!!!!!!!!!!!!!conditions not matched for "+patientDetails.get(i).getPatientName());
			failedList.add(patientDetails.get(i));
			
		  }
	  }
      System.out.println(failedList.size());
      if(!list.isEmpty())
      {
    	  return list;
      }
//      else
//      {
//    	  return  failedList;
//      }
//      
      
     
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
    return null;
  }
  
  
  

  public static ByteArrayInputStream tutorialsToCSV(List<PatientDetails> tutorials) {
    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
      for (PatientDetails tutorial : tutorials) {
        List<String> data = Arrays.asList(
           
           //  String.valueOf(tutorial.getId()),
            
           
             tutorial.getAddress(),
             tutorial.getDob(),
           
             tutorial.getDrugId(),
             tutorial.getDrugName(),
             tutorial.getEmailId(),
             tutorial.getPatientName(),
             tutorial.getPhoneNumber());
        

        csvPrinter.printRecord(data);
        
      }

      csvPrinter.flush();
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
    }
  }

}