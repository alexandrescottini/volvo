package br.com.prova.dto;

public class UsuarioDto {
	private Long id;
	private String nome;
	private String descricao;
	private Long idDpto;
	private Long idPermissao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getIdDpto() {
		return idDpto;
	}
	public void setIdDpto(Long idDpto) {
		this.idDpto = idDpto;
	}
	public Long getIdPermissao() {
		return idPermissao;
	}
	public void setIdPermissao(Long idPermissao) {
		this.idPermissao = idPermissao;
	}
	
	
}
