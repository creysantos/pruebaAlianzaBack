package com.prueba.alianza.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteDTO {
	private String sharedKey;
	private String businessId;
	private String email;
	private String phone;
	private String dataAdded;

}
