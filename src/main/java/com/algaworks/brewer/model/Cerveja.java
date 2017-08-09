package com.algaworks.brewer.model;

import javax.validation.constraints.NotBlank;

public class Cerveja {

	@NotBlank
	private String sku;
	@NotBlank
	private String nome;
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
