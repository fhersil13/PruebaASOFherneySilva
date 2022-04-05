package com.novatec.pruebaaso.app.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.novatec.pruebaaso.app.documents.Producto;
import com.novatec.pruebaaso.app.repository.IProductoRepository;

@RestController //Controlador de tipo Rest
@CrossOrigin(origins="http://localhost:3306", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/producto")//Se accede a través de esta URL
public class ProductoController {
	
	@Autowired
	private IProductoRepository iProductoRepository;
	
	//Creando un nuevo producto
	@PostMapping("/")
	public ResponseEntity<?> crear(@RequestBody Producto producto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(iProductoRepository.save(producto));
		
	}
	
	//Listar todos los productos
	@GetMapping("/")
	public List<Producto> leerTodos(){
		List<Producto> producto = StreamSupport.stream(iProductoRepository.findAll().spliterator(),false).collect(Collectors.toList());
		return producto;
	}
	
	//Leer un producto por id
	@GetMapping("/listar-id/{id}")
	public ResponseEntity<?> leer(@PathVariable(value="id") String id){
		Optional<Producto> producto = iProductoRepository.findById(id);
		if (!producto.isPresent()) {
			return ResponseEntity.notFound().build(); 
		}
		return ResponseEntity.ok(producto);
	}
	
	//Editar un producto
	@PutMapping("/")
	public ResponseEntity<?> editar(@RequestBody Producto productoEditar){
		return ResponseEntity.status(HttpStatus.CREATED).body(iProductoRepository.save(productoEditar));
	}
	
	//Eliminar un producto
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(value="id") String id){
		if (!iProductoRepository.findById(id).isPresent()) {
			return ResponseEntity.notFound().build(); 
		}
		
		iProductoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
