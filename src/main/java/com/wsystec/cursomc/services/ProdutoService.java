package com.wsystec.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsystec.cursomc.domain.Produto;
import com.wsystec.cursomc.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
