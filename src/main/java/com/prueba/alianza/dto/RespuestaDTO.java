package com.prueba.alianza.dto;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RespuestaDTO {

	private String categoria;
	private String codigo;
	private String descripcion;
	private int estado;
	private String tiempoRespuesta;
	
	private Object objetoRespuesta;
	private String variable;
	
	public RespuestaDTO(){
	}

	public RespuestaDTO(HttpStatus estado, String mensaje) {
		super();
		this.tiempoRespuesta = OffsetDateTime.now().toString();
		this.estado = estado.value();
		this.codigo = estado.name();
		this.descripcion = mensaje;
		this.variable = "";
		this.categoria = "DEFAULT_CATEGORY";
	}
	
	public RespuestaDTO(HttpStatus estado, String mensaje, String variable) {
		super();
		this.tiempoRespuesta = OffsetDateTime.now().toString();
		this.estado = estado.value();
		this.codigo = estado.name();
		this.descripcion = mensaje;
		this.variable = variable;
		this.categoria = "DEFAULT_CATEGORY";
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getTiempoRespuesta() {
		return tiempoRespuesta;
	}

	public void setTiempoRespuesta(String tiempoRespuesta) {
		this.tiempoRespuesta = tiempoRespuesta;
	}

	public Object getObjetoRespuesta() {
		return objetoRespuesta;
	}

	public void setObjetoRespuesta(Object objetoRespuesta) {
		this.objetoRespuesta = objetoRespuesta;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}
				
}
