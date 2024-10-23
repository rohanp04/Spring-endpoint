package com.example.deliveryboy.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;
    private final LocalDateTime timestamp;

    // Constructor for simple message
    public ResourceNotFoundException(String message) {
        super(message);
        this.timestamp = LocalDateTime.now();
        this.resourceName = null; // Handle appropriately
        this.fieldName = null; // Handle appropriately
        this.fieldValue = null; // Handle appropriately
    }

    // Constructor for detailed resource information
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}