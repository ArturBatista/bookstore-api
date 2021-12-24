package com.artur.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artur.bookstore.domain.Livro;
import com.artur.bookstore.repositories.CategoriaRepository;
import com.artur.bookstore.repositories.LivroRepository;
import com.artur.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	CategoriaService categoriaService;
	
	public Livro findById(int id) {
		Optional<Livro> livro = livroRepository.findById(id);
		return livro.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado Id: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return livroRepository.findAllByCategoria(id_cat);
	}

}
