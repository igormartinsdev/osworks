package com.algaworks.osworks.api.dto;

import javax.validation.constraints.NotNull;

public class ClienteIdInputDTO {
	
	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
