package com.novatec.pruebaaso.app.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Producto {

	@Id
	private String id;
	private String nombre;
	private String descripcion;
	
	private Double precio;
	
	//Fecha de registro
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	
	public Producto(String nombre, String descripcion, Double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
}
