package br.com.arm.controller.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.arm.controller.service.exception.NomeCategoriaCadastradoException;
import br.com.arm.model.Categoria;
import br.com.arm.repository.Categorias;

@Service
public class CadastroCategoriaService {

	@Autowired
	private Categorias categorias;

	@Transactional
	public void salvar(Categoria categoria) {

		Optional<Categoria> categoriaOptional = categorias.findByNomeIgnoreCase(categoria.getNome());
		if (categoriaOptional.isPresent()) {
			throw new NomeCategoriaCadastradoException("Nome da Categoria já cadastrado");
		}

		categorias.save(categoria);
	}

}
