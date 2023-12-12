package com.sena.continentes.Controller;

import com.sena.continentes.Entity.Continentes;
import com.sena.continentes.Entity.Pais;
import com.sena.continentes.IService.IPaisServices;
import com.sena.continentes.IService.IcontinentesServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/paises")
public class PaisController {

    @Autowired
    private IPaisServices service;

    @Autowired
    private IcontinentesServices continentesService;

    @GetMapping
    public List<Pais> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Optional<Pais> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
public Pais save(@RequestBody Pais pais) {
    if (pais.getContinente() == null) {
        throw new RuntimeException("El campo 'continente' no puede ser nulo.");
    }

    Continentes continente = continentesService.findById(pais.getContinente().getId())
            .orElseThrow(() -> new RuntimeException("Continente no encontrado"));

    pais.setContinente(continente);

    return service.save(pais);
}


    @PutMapping("{id}")
    public void save(@RequestBody Pais pais, @PathVariable Long id) {
        Continentes continente = continentesService.findById(pais.getContinente().getId())
                .orElseThrow(() -> new RuntimeException("Continente no encontrado"));

        pais.setId(id);
        pais.setContinente(continente);

        service.update(pais, id);
    }

    @PutMapping("deleted-at/{id}")
    public void deletedAt(@PathVariable Long id) {
        service.deletedAt(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
