package com.novatec.pruebaaso.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.novatec.pruebaaso.app.documents.Producto;
import com.novatec.pruebaaso.app.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Producto> findAll() {
		return iProductoRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Producto> findAll(Pageable pagebale) {
		return iProductoRepository.findAll(pagebale);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Producto> findById(String id) {
		return iProductoRepository.findById(id);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return iProductoRepository.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		iProductoRepository.deleteById(id);
	}

}
