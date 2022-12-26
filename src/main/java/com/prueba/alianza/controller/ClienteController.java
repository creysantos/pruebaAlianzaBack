package com.prueba.alianza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.alianza.dto.ClienteDTO;
import com.prueba.alianza.service.interfaces.IClienteService;

@RestController
@RequestMapping("api/client")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping(value = "consultar")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Object> consultarClientes(
			@RequestParam(name = "parametroBusqueda", required = false) String parametroBusqueda) {
		return clienteService.obtenerClientes(parametroBusqueda);

	}

	@PostMapping(value = "guardar")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Object> guardarCliente(@RequestBody ClienteDTO cliente) {
		return clienteService.guardarCliente(cliente);
	}
}
