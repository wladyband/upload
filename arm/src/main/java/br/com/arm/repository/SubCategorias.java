package br.com.arm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arm.model.Categoria;
import br.com.arm.model.SubCategoria;
@Repository
public interface SubCategorias extends JpaRepository<SubCategoria, Long> {

	public List<SubCategoria> findByCategoriaCodigo(Long CodigoCategoria);
	public Optional<SubCategoria> findByNomeAndCategoria(String nome, Categoria categoria);
}
