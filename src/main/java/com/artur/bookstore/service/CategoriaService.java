package com.artur.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artur.bookstore.domain.Categoria;
import com.artur.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired CategoriaRepository repository;
	
	public Categoria findById(Integer id) {
		
		Optional<Categoria> obj = repository.findById(id);
		
		return obj.orElse(null);
	}
}
