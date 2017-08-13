package com.algaworks.brewer.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Cerveja {

	@NotBlank
	private String sku;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Size(min=3, max=50)
	private String descricao; //Obrigatoria e tamanho máximo < 50 characs
	
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
