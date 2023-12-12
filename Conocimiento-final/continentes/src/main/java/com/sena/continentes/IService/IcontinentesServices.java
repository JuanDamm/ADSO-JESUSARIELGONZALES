package com.sena.continentes.IService;

import java.util.List;
import java.util.Optional;

import com.sena.continentes.Entity.Continentes;;
public interface IcontinentesServices {
    /**
	 * Método para consultar todo
	 * **/
	public List<Continentes> findAll();
	
	/**
	 * Método para consultar por id
	 * **/
	public Optional<Continentes> findById(Long id);
	
	
	/**
	 * Método para guardar
	 * **/
	public Continentes save(Continentes continente);
	
	/**
	 * Método para modificar
	 * **/
	public void update(Continentes continente, Long id);
	
	/**
	 * Método para eliminar
	 * **/
	public void delete(Long id);
	
	/**
	 * Método para eliminar lógico
	 * **/
	public void deletedAt(Long id);
}
