package com.kevin.Farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.Farmacia.model.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long>{
    
}
