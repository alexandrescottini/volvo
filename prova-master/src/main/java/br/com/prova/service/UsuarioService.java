package br.com.prova.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prova.dto.UsuarioDto;
import br.com.prova.model.Departamento;
import br.com.prova.model.Permissao;
import br.com.prova.model.Usuario;
import br.com.prova.repository.DepartamentoRepository;
import br.com.prova.repository.PermissaoRepository;
import br.com.prova.repository.UsuarioRepository;

@Component
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	DepartamentoRepository departamentoRepository;
	
	@Autowired
	PermissaoRepository permissaoRepository;
	
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	public void salvar(UsuarioDto dto) {
		Permissao permissao = permissaoRepository.findOne(dto.getIdPermissao());
		Departamento dpto = departamentoRepository.findOne(dto.getIdDpto());
		if(permissao == null || dpto == null) {
			throw new IllegalArgumentException();
		}
		Usuario usuario = toUsuario(dto);
		usuario.setDepartamento(dpto);
		usuario.setPermissao(permissao);
		usuarioRepository.save(usuario);
	}
	
	public UsuarioDto buscarPorId(Long id) {
		Usuario usuario = usuarioRepository.findOne(id);
		UsuarioDto dto;
		if(usuario != null) {
			dto = toDto(usuario);
			return dto;
		}
		return null;
	}
	
	public UsuarioDto atualizar(Long id, UsuarioDto dto) {
		Usuario user = usuarioRepository.findOne(id);
		if(user == null) {
			throw new IllegalArgumentException();
		}
		
		Permissao permissao = permissaoRepository.findOne(dto.getIdPermissao());
		Departamento dpto = departamentoRepository.findOne(dto.getIdDpto());
		
		if(permissao == null || dpto == null) {
			throw new IllegalArgumentException();
		}
		
		user.setDepartamento(dpto);
		user.setPermissao(permissao);
		user.setNome(dto.getNome());
		user.setDescricao(dto.getDescricao());
		
		usuarioRepository.save(user);
		
		return toDto(user);
	}
	
	public void excluir(Long id) {
		usuarioRepository.delete(id);
	}
	
	private Usuario toUsuario(UsuarioDto dto) {
		Usuario user = new Usuario();
		user.setNome(dto.getNome());
		user.setDescricao(dto.getDescricao() != null ? dto.getDescricao() : null);
		return user;
	}
	
	private UsuarioDto toDto(Usuario usuario) {
		UsuarioDto dto = new UsuarioDto();
		dto.setId(usuario.getId());
		dto.setNome(usuario.getNome());
		dto.setDescricao(usuario.getDescricao());
		dto.setIdDpto(usuario.getDepartamento().getId());
		dto.setIdPermissao(usuario.getPermissao().getId());
		return dto;
	}
}
