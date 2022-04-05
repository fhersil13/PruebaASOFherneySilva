package com.novatec.pruebaaso.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.novatec.pruebaaso.app.documents.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, String>{

}
