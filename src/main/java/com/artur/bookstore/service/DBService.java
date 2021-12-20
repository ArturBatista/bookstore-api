package com.artur.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artur.bookstore.domain.Categoria;
import com.artur.bookstore.domain.Livro;
import com.artur.bookstore.repositories.CategoriaRepository;
import com.artur.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null,"Informática","Livros de TI");
		Categoria cat2 = new Categoria(null,"Ficção Cientifica","Ficção Cientifica");
		Categoria cat3 = new Categoria(null,"Biografias","Livros de Biografias");
	
		Livro l1 = new Livro(null, "Clean code", "Roberto Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Um Bate-papo Sobre T.I. ", "Ernesto Haberkon", "Lorem ipsum", cat1);
		
		Livro l3 = new Livro(null, "Engenharia de Software: Uma Abordagem Profissional", "Roger S. Pressman", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "O Poder dos Quietos ", "Susan Cain", "Lorem ipsum", cat2);
		Livro l5 = new Livro(null, "O Verdadeiro Valor de TI ", "Richard Hunter e George Westerman", "Lorem ipsum", cat2);
		
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
	}

}
