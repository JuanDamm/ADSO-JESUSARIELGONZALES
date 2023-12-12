package com.sena.continentes.IService;

import java.util.List;
import java.util.Optional;

import com.sena.continentes.Entity.Pais;

public interface IPaisServices {
    List<Pais> findAll();
    Optional<Pais> findById(Long id);
    Pais save(Pais pais);
    void update(Pais pais, Long id);
    void deletedAt(Long id);
    void delete(Long id);
}
