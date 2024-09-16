package com.kevin.Farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.Farmacia.exception.ResourceNotFoundException;
import com.kevin.Farmacia.model.Log;
import com.kevin.Farmacia.repository.LogRepository;

import jakarta.validation.Valid;

@Service
public class LogService {
    
    @Autowired
    private LogRepository LogRepository;
    
    public Log saveLog(@Valid Log log){
        return LogRepository.save(log);
    }

    public List<Log> findLogs(){
        return LogRepository.findAll();
    }

    public Optional<Log> findById (Long id){
        return LogRepository.findById(id);
    }
    public void deleteById (Long id){
        LogRepository.deleteById(id);
    }
    public Log updateLog(Long id, @Valid Log logDetalle){
        if (!LogRepository.existsById(id)) {
            throw new ResourceNotFoundException("Log no encontrado con id: " + id);
        }

        Log existeLog = LogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Log no encontrado con id: " + id));

        existeLog.setMessage(logDetalle.getMessage());
        existeLog.setFechahora(logDetalle.getFechahora());
        existeLog.setEsActivo(logDetalle.getEsActivo());

        return LogRepository.save(existeLog);
    }

}
