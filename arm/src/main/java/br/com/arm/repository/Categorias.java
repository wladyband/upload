package br.com.arm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arm.model.Categoria;
@Repository
public interface Categorias extends JpaRepository<Categoria, Long> {
	
	public Optional<Categoria> findByNomeIgnoreCase(String nome);

}
