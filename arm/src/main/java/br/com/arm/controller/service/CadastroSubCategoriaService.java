package br.com.arm.controller.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.arm.controller.service.exception.NomeSubCategoriaJaCadastradaException;
import br.com.arm.model.SubCategoria;
import br.com.arm.repository.SubCategorias;

@Service
public class CadastroSubCategoriaService {

	@Autowired
	private SubCategorias subCategorias;
	
	@Transactional
	public void salvar(SubCategoria subCategoria){
		Optional<SubCategoria> subCategoriaExistente = subCategorias.findByNomeAndCategoria(subCategoria.getNome(), subCategoria.getCategoria());
		if(subCategoriaExistente.isPresent()){
			throw new NomeSubCategoriaJaCadastradaException("Nome de da SubCategoria do produto já cadastrado");
		}
		
		subCategorias.save(subCategoria);
	}
}
