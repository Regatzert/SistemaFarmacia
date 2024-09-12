package com.kevin.Farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.Farmacia.model.Promocion;

@Repository
public interface PromocionRepository extends JpaRepository<Promocion, Long>{
    
}
