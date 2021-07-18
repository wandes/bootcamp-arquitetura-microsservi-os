package br.com.equipment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EquipmentNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public EquipmentNotFoundException(Long id) {
		super(String.format("Equipamento com o id %s não localizado", id));
	}

}
