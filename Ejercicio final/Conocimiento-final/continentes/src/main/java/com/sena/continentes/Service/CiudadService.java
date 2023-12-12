package com.sena.continentes.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.continentes.Entity.Ciudad;
import com.sena.continentes.IRepository.ICiudadRepository;
import com.sena.continentes.IService.ICiudadServices;

@Service
public class CiudadService implements ICiudadServices {

    @Autowired
    private ICiudadRepository ciudadRepository;

    @Override
    public List<Ciudad> findAll() {
        return ciudadRepository.findAll();
    }

    @Override
    public Optional<Ciudad> findById(Long id) {
        return ciudadRepository.findById(id);
    }

    @Override
    public Ciudad save(Ciudad ciudad) {
        ciudad.setFechaCreacion(LocalDateTime.now());
        return ciudadRepository.save(ciudad);
    }

    @Override
    public void update(Ciudad ciudad, Long id) {
        Optional<Ciudad> op = ciudadRepository.findById(id);
        if (op.isEmpty()) {
            System.out.print("Registro no existe.");
        } else {
            Ciudad updateCiudad = op.get();
            updateCiudad.setCodigo(ciudad.getCodigo());
            updateCiudad.setNombre(ciudad.getNombre());
            updateCiudad.setDepartamento(ciudad.getDepartamento());
            updateCiudad.setEstado(ciudad.getEstado());
            updateCiudad.setFechaModificacion(LocalDateTime.now());
            ciudadRepository.save(updateCiudad);
        }
    }

    @Override
    public void deletedAt(Long id) {
        Optional<Ciudad> op = ciudadRepository.findById(id);
        if (op.isEmpty()) {
            System.out.print("Registro no existe para eliminar.");
        } else {
            Ciudad updateCiudad = op.get();
            updateCiudad.setFechaEliminacion(LocalDateTime.now());
            ciudadRepository.save(updateCiudad);
        }
    }

    @Override
    public void delete(Long id) {
        ciudadRepository.deleteById(id);
    }
}
