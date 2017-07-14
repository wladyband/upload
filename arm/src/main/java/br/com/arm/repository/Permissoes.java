package br.com.arm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arm.model.Permissao;

@Repository
public interface Permissoes extends JpaRepository<Permissao, Long> {

}
