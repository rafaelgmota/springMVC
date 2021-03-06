package com.algaworks.brewer.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.algaworks.brewer.validation.SKU;

@Entity
@Table(name = "cerveja")
public class Cerveja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long codigo;

	@SKU
	@NotBlank(message = "SKU é obrigatório")
	private String sku;
	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@Size(min=1, max=50, message = "A descrição deve ter tamanho entre 3 e 50 e é obrigatória")
	private String descricao; //Obrigatoria e tamanho máximo < 50 characs
	
	@NotNull(message="O valor é obrigatório")
	@DecimalMin(value="0.50", message="O valor mínimo da cerveja é: R$ 0,50")
	@DecimalMax(value="1000.0", message="O valor máximo da cerveja é: R$ 1000")
	private BigDecimal valor;
	
	@NotNull(message="O teor alcoolico é obrigatório")
	@DecimalMin(value="0.00", message="O teor alcoolico mínimo é 0.00%")
	@DecimalMax(value="100.0", message="O teor alcoolico máximo é 100.00%")
	@Column(name = "teor_alcoolico") //Só para setar o nome sem camel case
	private BigDecimal teorAlcoolico;
	
	@NotNull(message="A comissão é obrigatória")
	@DecimalMax(value = "100.00", message="A comissão máxima é de 100%")	
	@DecimalMin(value = "2.0", message="A comissão mínima é de 2%")
	private BigDecimal comissao;
	
	@NotNull(message="Quantidade estoque é obrigatória")
	@Max(value=9999, message="A quantidade em estoque máximo é 9999")
	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;
	
	@NotNull(message="A origem é obrigatória")
	@Enumerated(EnumType.STRING)
	private Origem origem;
	
	@NotNull(message="O sabor é obrigatório")
	@Enumerated(EnumType.STRING)
	private Sabor sabor;
	
	@NotNull(message="O estilo é obrigatório")
	@ManyToOne
	@JoinColumn(name = "codigo_estilo")
	private Estilo estilo;
	
	//JPA Callbacks
	@PrePersist @PreUpdate //Will be executed before persist and update
	private void prePersistUpdate() {
		sku = sku.toUpperCase();
	}
	
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
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}
	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}
	public BigDecimal getComissao() {
		return comissao;
	}
	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Origem getOrigem() {
		return origem;
	}
	public void setOrigem(Origem origem) {
		this.origem = origem;
	}
	public Sabor getSabor() {
		return sabor;
	}
	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}
	public Estilo getEstilo() {
		return estilo;
	}
	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
}
