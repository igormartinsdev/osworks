package com.algaworks.osworks.api.dto;

import javax.validation.constraints.NotBlank;

public class ComentarioInputDTO {
	
	@NotBlank
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
