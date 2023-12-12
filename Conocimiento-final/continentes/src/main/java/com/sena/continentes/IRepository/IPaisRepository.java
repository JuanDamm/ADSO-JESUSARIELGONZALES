package com.sena.continentes.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.continentes.Entity.Pais;

public interface IPaisRepository extends JpaRepository<Pais, Long> {
}
