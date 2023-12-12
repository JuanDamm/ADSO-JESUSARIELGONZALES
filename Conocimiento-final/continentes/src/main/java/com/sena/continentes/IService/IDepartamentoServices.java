package com.sena.continentes.IService;

import java.util.List;
import java.util.Optional;

import com.sena.continentes.Entity.Departamento;

public interface IDepartamentoServices {

    List<Departamento> findAll();

    Optional<Departamento> findById(Long id);

    Departamento save(Departamento departamento);

    void update(Departamento departamento, Long id);

    void deletedAt(Long id);

    void delete(Long id);
}
