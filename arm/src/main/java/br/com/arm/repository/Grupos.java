package br.com.arm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arm.model.Grupo;

@Repository
public interface Grupos extends JpaRepository<Grupo, Long>{

}
