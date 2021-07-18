package br.com.equipment.service;

import java.util.List;

import br.com.equipment.dto.request.EquipmentRequestDTO;
import br.com.equipment.dto.response.EquipmentResponseDTO;
import br.com.equipment.exception.EquipmentNotFoundException;

public interface EquipmentService {
	
	EquipmentResponseDTO create(EquipmentRequestDTO equipmentDTO);
	
	EquipmentResponseDTO findById(Long id) throws EquipmentNotFoundException;
	
	void delete(Long id) throws EquipmentNotFoundException;
	
	List<EquipmentResponseDTO> finAll();
	
	EquipmentResponseDTO update(Long id, EquipmentRequestDTO equipmentDTO) throws EquipmentNotFoundException;
	
}
