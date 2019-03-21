package br.com.prova.service;

import java.util.List;

import javax.swing.plaf.basic.BasicTreeUI.TreeHomeAction;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prova.model.Departamento;
import br.com.prova.repository.DepartamentoRepository;

@Component
public class DepartamentoService {
	
	@Autowired
	DepartamentoRepository departamentoRepository;

	public void salvar(Departamento departamento) {
		departamentoRepository.save(departamento);
	}
	
	public List<Departamento> listar(){
		return departamentoRepository.findAll();
	}
	
	public Departamento buscarPorId(Long id) {
		return departamentoRepository.findOne(id);
	}
	
	
	public Departamento atualizar(Long id, Departamento departamento) {
		Departamento dpto = departamentoRepository.findOne(id);
		
		if(dpto == null) {
			throw new IllegalArgumentException();
		}
		
		BeanUtils.copyProperties(departamento, dpto, "id");
		return departamentoRepository.save(dpto);
	}
	
	public void excluir(Long id) {
		departamentoRepository.delete(id);
	}
}
