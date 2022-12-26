package com.prueba.alianza.service.interfaces;

import org.springframework.http.ResponseEntity;

import com.prueba.alianza.dto.ClienteDTO;

public interface IClienteService {
	
	ResponseEntity<Object> obtenerClientes(String parametroBusqueda);
	ResponseEntity<Object> guardarCliente(ClienteDTO cliente);

}
