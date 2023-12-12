package com.sena.continentes.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.continentes.Entity.Ciudad;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Long> {
    
}
