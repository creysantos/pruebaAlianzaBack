package com.prueba.alianza.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.alianza.dto.ClienteDTO;
import com.prueba.alianza.dto.RespuestaDTO;
import com.prueba.alianza.service.interfaces.IClienteService;

@Service
public class ClienteService implements IClienteService {
	private static final Logger logger = LogManager.getLogger(ClienteService.class);
	private List<ClienteDTO> listaClientes = new ArrayList<>();

	public ClienteService() {
		consultarClientes();
	}

	@Override
	public ResponseEntity<Object> obtenerClientes(String parametroBusqueda) {
		RespuestaDTO rta = new RespuestaDTO(HttpStatus.OK, "Consulta de Clientes");
		logger.info("Consulta de Clientes");
		if (parametroBusqueda == null || parametroBusqueda.isEmpty()) {
			rta.setObjetoRespuesta(this.listaClientes);
		} else {
			List<ClienteDTO> listaClienteFiltrado = new ArrayList<>();
			listaClienteFiltrado = listaClientes.stream()
					.filter((cliente) -> cliente.getSharedKey().equals(parametroBusqueda)).collect(Collectors.toList());
			rta.setObjetoRespuesta(listaClienteFiltrado);
			logger.info("Busqueda de Clientes");
		}
		ResponseEntity<Object> respuesta = new ResponseEntity<>(rta, HttpStatus.OK);
		return respuesta;
	}

	private List<ClienteDTO> consultarClientes() {
		ClienteDTO cliente1 = new ClienteDTO("jgutierrez", "Juliana Gutierrez", "jgutierrez@gmail.com", "3219876543",
				"20/05/2019");
		ClienteDTO cliente2 = new ClienteDTO("mmartinez", "Manuel Martinez", "mmartinez@gmail.com", "3219876543",
				"20/05/2019");
		ClienteDTO cliente3 = new ClienteDTO("aruiz", "Ana Ruiz", "aruiz@gmail.com", "3219876543", "20/05/2019");

		ClienteDTO cliente4 = new ClienteDTO("ogarcia", "Oscar Garcia", "ogarcia@gmail.com", "3219876543",
				"20/05/2019");
		ClienteDTO cliente5 = new ClienteDTO("tramos", "Tania Ramos", "tramos@gmail.com", "3219876543", "20/05/2019");
		ClienteDTO cliente6 = new ClienteDTO("cariza", "Carlos Ariza", "cariza@gmail.com", "3219876543", "20/05/2019");
		ClienteDTO cliente7 = new ClienteDTO("rvillaneda", "Rodrigo Villaneda", "rvillaneda@gmail.com", "3219876543",
				"20/05/2019");
		ClienteDTO cliente8 = new ClienteDTO("mfonseca", "Mauricio Fonseca", "mfonseca@gmail.com", "3219876543",
				"20/05/2019");
		this.listaClientes.add(cliente1);
		this.listaClientes.add(cliente2);
		this.listaClientes.add(cliente3);
		this.listaClientes.add(cliente4);
		this.listaClientes.add(cliente5);
		this.listaClientes.add(cliente6);
		this.listaClientes.add(cliente7);
		this.listaClientes.add(cliente8);
		return this.listaClientes;
	}

	@Override
	public ResponseEntity<Object> guardarCliente(ClienteDTO cliente) {
		RespuestaDTO rta = new RespuestaDTO(HttpStatus.OK, "Guardar Cliente");
		this.listaClientes.add(cliente);
		rta.setObjetoRespuesta(listaClientes);
		logger.info("Cliente Guardado Exitosamente");
		ResponseEntity<Object> respuesta = new ResponseEntity<>(rta, HttpStatus.OK);
		return respuesta;
	}

}
