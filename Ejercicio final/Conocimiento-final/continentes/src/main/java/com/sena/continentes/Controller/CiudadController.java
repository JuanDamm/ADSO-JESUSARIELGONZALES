package com.sena.continentes.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sena.continentes.Entity.Ciudad;
import com.sena.continentes.IService.ICiudadServices;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/ciudades")
public class CiudadController {

    @Autowired
    private ICiudadServices ciudadService;

    @GetMapping
    public List<Ciudad> findAll() {
        return ciudadService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Ciudad> findById(@PathVariable Long id) {
        return ciudadService.findById(id);
    }

    @PostMapping
    public Ciudad save(@RequestBody Ciudad ciudad) {
        return ciudadService.save(ciudad);
    }

    @PutMapping("{id}")
    public void save(@RequestBody Ciudad ciudad, @PathVariable Long id) {
        ciudadService.update(ciudad, id);
    }

    @PutMapping("deleted-at/{id}")
    public void deletedAt(@PathVariable Long id) {
        ciudadService.deletedAt(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        ciudadService.delete(id);
    }
}
