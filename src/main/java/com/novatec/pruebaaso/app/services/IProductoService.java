package com.novatec.pruebaaso.app.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.novatec.pruebaaso.app.documents.Producto;

public interface IProductoService {
	
	public Iterable<Producto> findAll(); //Devuelve un Iterable del objeto producto
	
	public Page<Producto> findAll(Pageable pagebale);
	
	public Optional<Producto> findById(String id); 
	
	public Producto save(Producto producto);
	
	public void deleteById(String id);

}
