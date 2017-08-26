package com.algaworks.brewer.model;

import javax.validation.constraints.NotBlank;

public class Cliente {

	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "CPF/CNPJ é obrigatório")
	private String cpfCnpj;
	
	@NotBlank(message = "Telefone é obrigatório")
	private String telefone;
	
	@NotBlank(message = "Email é obrigatório")
	private String email;
	
	@NotBlank(message = "Logradouro é obrigatório")
	private String logradouro;
	
	private int numero;
	
	private String complemento;
	
	@NotBlank(message = "CEP é obrigatório")
	private String cep;	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCPfCnpj() {
		return cpfCnpj;
	}
	
	public void setCpfCnpj(String CpfCnpj) {
		this.cpfCnpj = CpfCnpj;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
}
