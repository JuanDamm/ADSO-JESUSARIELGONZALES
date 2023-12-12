package com.sena.continentes.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.continentes.Entity.Continentes;
import com.sena.continentes.IService.IcontinentesServices;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/continentes")
public class ContinentesController {

    @Autowired
	private IcontinentesServices service;
	
	@GetMapping
	public List<Continentes> findAll() {
		return service.findAll();
	}

    @GetMapping("{id}")
	public Optional<Continentes> findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Continentes save(@RequestBody Continentes continente) {
		return service.save(continente);
	}
	
	@PutMapping("{id}")
	public void save(@RequestBody Continentes continente, @PathVariable  Long id) {
		service.update(continente, id);
	}
	
	@PutMapping("deleted-at/{id}")
	public void deletedAt(@PathVariable  Long id) {
		service.deletedAt(id);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable  Long id) {
		service.delete(id);
	}
    
}
