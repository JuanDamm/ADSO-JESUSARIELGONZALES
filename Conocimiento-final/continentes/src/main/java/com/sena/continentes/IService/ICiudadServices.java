package com.sena.continentes.IService;

import java.util.List;
import java.util.Optional;

import com.sena.continentes.Entity.Ciudad;

public interface ICiudadServices {

    List<Ciudad> findAll();

    Optional<Ciudad> findById(Long id);

    Ciudad save(Ciudad ciudad);

    void update(Ciudad ciudad, Long id);

    void deletedAt(Long id);

    void delete(Long id);
}
