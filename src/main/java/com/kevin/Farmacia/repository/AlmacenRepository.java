package com.kevin.Farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.Farmacia.model.Almacen;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Long>{
    
}
