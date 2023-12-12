package com.sena.continentes.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.continentes.Entity.Departamento;
import com.sena.continentes.IRepository.IDepartamentoRepository;
import com.sena.continentes.IService.IDepartamentoServices;

@Service
public class DepartamentoService implements IDepartamentoServices {

    @Autowired
    private IDepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }

    @Override
    public Optional<Departamento> findById(Long id) {
        return departamentoRepository.findById(id);
    }

    @Override
    public Departamento save(Departamento departamento) {
        departamento.setFechaCreacion(LocalDateTime.now());
        return departamentoRepository.save(departamento);
    }

    @Override
    public void update(Departamento departamento, Long id) {
        Optional<Departamento> op = departamentoRepository.findById(id);
        if (op.isEmpty()) {
            System.out.print("Registro no existe.");
        } else {
            Departamento updateDepartamento = op.get();
            updateDepartamento.setCodigo(departamento.getCodigo());
            updateDepartamento.setNombre(departamento.getNombre());
            updateDepartamento.setPais(departamento.getPais());
            updateDepartamento.setEstado(departamento.getEstado());
            updateDepartamento.setFechaModificacion(LocalDateTime.now());
            departamentoRepository.save(updateDepartamento);
        }
    }

    @Override
    public void deletedAt(Long id) {
        Optional<Departamento> op = departamentoRepository.findById(id);
        if (op.isEmpty()) {
            System.out.print("Registro no existe para eliminar.");
        } else {
            Departamento updateDepartamento = op.get();
            updateDepartamento.setFechaEliminacion(LocalDateTime.now());
            departamentoRepository.save(updateDepartamento);
        }
    }

    @Override
    public void delete(Long id) {
        departamentoRepository.deleteById(id);
    }
}
