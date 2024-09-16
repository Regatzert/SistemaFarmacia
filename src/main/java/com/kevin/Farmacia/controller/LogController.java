package com.kevin.Farmacia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.Farmacia.model.Log;
import com.kevin.Farmacia.service.LogService;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/log")
@Validated
public class LogController {
    
    @Autowired
    private LogService logService;

    @PostMapping //Metodo para guardar un nuevo Log
    public ResponseEntity<Log> saveLog(@Valid @RequestBody Log Log){
        Log guardarLog = logService.saveLog(Log);
        return new ResponseEntity<>(guardarLog, HttpStatus.CREATED);
    }

    @GetMapping //Metodo para listar todos los Logs
    public ResponseEntity<List<Log>> getAllLog(){
        List<Log> listLogs = logService.findLogs();
        return ResponseEntity.ok(listLogs);
    }

    @GetMapping("/{id}") //Metodo para buscar un solo Log por ID
    public ResponseEntity<Log> getLogById(@PathVariable Long id){
        Optional<Log> Log = logService.findById(id);
        return Log.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id){
        if (logService.findById(id).isPresent()) {
            logService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Log> updateLog(@PathVariable Long id){
        if (logService.findById(id).isPresent()) {
            logService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
