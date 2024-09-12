package com.kevin.Farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.Farmacia.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{
    
}
