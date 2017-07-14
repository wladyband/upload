package br.com.arm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arm.model.Cano;
import br.com.arm.repository.helper.hidraulico.CanosQueries;

@Repository
public interface Canos extends JpaRepository<Cano, Long>, CanosQueries {

}
