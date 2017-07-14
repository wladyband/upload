package br.com.arm.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.arm.model.Cano;
import br.com.arm.repository.Canos;

@Service
public class CadastroCanoService {
	
	@Autowired
	private Canos canos;
	
	@Transactional
	public void salvar(Cano cano){
		canos.save(cano);
	}
	
	
}
