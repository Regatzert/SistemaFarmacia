package com.kevin.Farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.Farmacia.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    
}
