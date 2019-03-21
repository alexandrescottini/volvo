package br.com.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prova.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

	
}
