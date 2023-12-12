package com.sena.continentes.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.continentes.IRepository.IcontinentesRepository;
import com.sena.continentes.IService.IcontinentesServices;
import com.sena.continentes.Entity.Continentes;


@Service  // Añade la anotación @Service
public class ContinentesService implements IcontinentesServices {

    @Autowired
    private IcontinentesRepository repository;

    @Override
    public List<Continentes> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Continentes> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Continentes save(Continentes continente) {
        continente.setFechaCreacion(LocalDateTime.now());
        return repository.save(continente);
    }

    @Override
    public void update(Continentes continente, Long id) {
        Optional<Continentes> op = repository.findById(id);
        if (op.isEmpty()) {
            System.out.print("Registro no existe.");
        } else {
            Continentes updateContinente = op.get();
            updateContinente.setNombre(continente.getNombre());
            updateContinente.setCodigo(continente.getCodigo());
            updateContinente.setEstado(continente.getEstado());
            updateContinente.setFechaModificacion(LocalDateTime.now());
            repository.save(updateContinente);
        }
    }

    @Override
    public void deletedAt(Long id) {
        Optional<Continentes> op = repository.findById(id);
        if (op.isEmpty()) {
            System.out.print("Registro no existe para eliminar.");
        } else {
            Continentes updateContinente = op.get();
            updateContinente.setFechaEliminacion(LocalDateTime.now());
            repository.save(updateContinente);
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
