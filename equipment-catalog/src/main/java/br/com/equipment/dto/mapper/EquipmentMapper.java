package br.com.equipment.dto.mapper;

import org.mapstruct.Mapper;

import br.com.equipment.dto.request.EquipmentRequestDTO;
import br.com.equipment.dto.response.EquipmentResponseDTO;
import br.com.equipment.model.Equipment;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {
	
	Equipment toModel(EquipmentRequestDTO requestDTO);
	
	EquipmentResponseDTO toDTO(Equipment equipment);
}
