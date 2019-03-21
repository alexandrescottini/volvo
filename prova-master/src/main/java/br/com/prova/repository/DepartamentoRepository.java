package br.com.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prova.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

	
}
