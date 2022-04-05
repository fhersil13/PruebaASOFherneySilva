package com.novatec.pruebaaso.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novatec.pruebaaso.app.documents.Producto;

public interface IProductoRepository extends JpaRepository<Producto, String>{

}
