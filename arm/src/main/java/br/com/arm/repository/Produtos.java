package br.com.arm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arm.model.Produto;

@Repository
public interface Produtos extends JpaRepository<Produto, Long> {

}
