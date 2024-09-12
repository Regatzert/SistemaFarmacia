package com.kevin.Farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.Farmacia.model.Soporte;

@Repository
public interface SoporteRepository extends JpaRepository<Soporte, Long>{
    
}
