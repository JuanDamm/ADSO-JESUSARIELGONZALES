package com.sena.continentes.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.continentes.Entity.Departamento;

@Repository
public interface IDepartamentoRepository extends JpaRepository<Departamento, Long> {
    
}
