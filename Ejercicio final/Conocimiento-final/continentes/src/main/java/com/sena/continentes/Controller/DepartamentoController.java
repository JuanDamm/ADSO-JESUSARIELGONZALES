package com.sena.continentes.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sena.continentes.Entity.Departamento;
import com.sena.continentes.IService.IDepartamentoServices;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/departamentos")
public class DepartamentoController {

    @Autowired
    private IDepartamentoServices departamentoService;

    @GetMapping
    public List<Departamento> findAll() {
        return departamentoService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Departamento> findById(@PathVariable Long id) {
        return departamentoService.findById(id);
    }

    @PostMapping
    public Departamento save(@RequestBody Departamento departamento) {
        return departamentoService.save(departamento);
    }

    @PutMapping("{id}")
    public void save(@RequestBody Departamento departamento, @PathVariable Long id) {
        departamentoService.update(departamento, id);
    }

    @PutMapping("deleted-at/{id}")
    public void deletedAt(@PathVariable Long id) {
        departamentoService.deletedAt(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        departamentoService.delete(id);
    }
}
