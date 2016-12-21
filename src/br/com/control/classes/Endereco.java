package br.com.control.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.control.enums.EnumUF;

@Entity
@Table(name = "CAD_ENDERECO")
public class Endereco {
	
	@Id @GeneratedValue
	@Column(name="ID")
	private Long id;
			
	@Column(name="RUA", length=100)
	private String rua;
	
	@Column(name="NUMERO", length=20)
	private String numero;
	
	@Column(name="COMPLEMENTO", length=20)
	private String complemento;
	
	@Column(name="PNT_DE_REFERENCIA", length=100)
	private String pontoDeReferencia;
	
	@Column(name="BAIRRO", length=80)
	private String bairro;
	
	@Column(name="CIDADE", length=80)
	private String cidade;
	
	@Column(name="UF", length=2)
	private EnumUF uf;
	
	@Column(name="CEP", length=10)
	private String cep;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getPontoDeReferencia() {
		return pontoDeReferencia;
	}
	public void setPontoDeReferencia(String pontoDeReferencia) {
		this.pontoDeReferencia = pontoDeReferencia;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public EnumUF getUf() {
		return uf;
	}
	public void setUf(EnumUF uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	
	

}
