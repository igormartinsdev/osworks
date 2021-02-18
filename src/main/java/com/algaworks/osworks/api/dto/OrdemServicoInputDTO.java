package com.algaworks.osworks.api.dto;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrdemServicoInputDTO {

	@NotBlank
	private String descricao;
	
	@NotNull
	private BigDecimal preco;
	
	@Valid
	@NotNull
	private ClienteIdInputDTO cliente;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public ClienteIdInputDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteIdInputDTO cliente) {
		this.cliente = cliente;
	}

}