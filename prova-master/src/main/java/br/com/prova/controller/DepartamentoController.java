package br.com.prova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.prova.model.Departamento;
import br.com.prova.service.DepartamentoService;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	DepartamentoService departamentoService;
	
		
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Departamento departamento){
		departamentoService.salvar(departamento);
	}
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Departamento> departamentos = departamentoService.listar();
		return !departamentos.isEmpty() ? ResponseEntity.ok(departamentos) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public Departamento buscarPorId(@PathVariable Long id) {
		return departamentoService.buscarPorId(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Departamento departamento){
		if(id == null) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(departamentoService.atualizar(id, departamento));
		}
	}	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		departamentoService.excluir(id);
	}
}
