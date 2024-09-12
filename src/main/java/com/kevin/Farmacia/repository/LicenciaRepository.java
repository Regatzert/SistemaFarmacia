package com.kevin.Farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.Farmacia.model.Licencia;

@Repository
public interface LicenciaRepository extends JpaRepository<Licencia, Long>{
    
}
