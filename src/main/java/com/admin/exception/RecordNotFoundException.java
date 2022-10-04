package com.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	public String getResourceName() {
		return resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	
	public RecordNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s is not found with the %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
}
