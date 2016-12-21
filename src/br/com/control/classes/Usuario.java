package br.com.control.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAD_USUARIO")
public class Usuario {
	
	@Id @GeneratedValue
	@Column(name="ID")
	private Long id;

	@Column(name="LOGIN", nullable=false, length=20)
	private String login;
	
	@Column(name="SENHA", nullable=false, length=20)
	private String senha;
	
	@Column(name="NOME", nullable=false, length=100)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
