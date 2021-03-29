package com.wsystec.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wsystec.cursomc.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {

		Categoria categoria = new Categoria(1, "Informatica");
		Categoria categori = new Categoria(2, "Consumo");

		List<Categoria> lista = new ArrayList<>();
		lista.add(categoria);
		lista.add(categori);

		return lista;
	}

}
