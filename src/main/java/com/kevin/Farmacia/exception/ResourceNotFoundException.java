package com.kevin.Farmacia.exception;

import com.fasterxml.jackson.databind.RuntimeJsonMappingException;

public class ResourceNotFoundException extends RuntimeJsonMappingException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
