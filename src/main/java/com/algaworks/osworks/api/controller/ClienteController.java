package com.algaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar(){
		var cliente1 = new Cliente();
		cliente1.setNome("João");
		cliente1.setId(1L);
		cliente1.setEmail("joao@teste.com");
		cliente1.setTelefone("(91)98745-2541");
		
		var cliente2 = new Cliente();
		cliente2.setNome("Joca");
		cliente2.setId(2L);
		cliente2.setEmail("joca@teste.com");
		cliente2.setTelefone("(91)98745-2541");
		
		return Arrays.asList(cliente1, cliente2);
	}
}
