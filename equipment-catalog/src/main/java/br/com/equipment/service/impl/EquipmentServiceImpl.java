package br.com.equipment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.equipment.dto.mapper.EquipmentMapper;
import br.com.equipment.dto.request.EquipmentRequestDTO;
import br.com.equipment.dto.response.EquipmentResponseDTO;
import br.com.equipment.exception.EquipmentNotFoundException;
import br.com.equipment.model.Equipment;
import br.com.equipment.repository.EquipmentRepository;
import br.com.equipment.service.EquipmentService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EquipmentServiceImpl implements EquipmentService {

	private EquipmentMapper equipmentMapper;

	public EquipmentRepository equipmentRepository;

	@Override
	public EquipmentResponseDTO create(EquipmentRequestDTO equipment) {

		return equipmentMapper.toDTO(equipmentRepository.save(equipmentMapper.toModel(equipment)));
	}

	@Override
	public EquipmentResponseDTO findById(Long id) throws EquipmentNotFoundException {

		Equipment equipment = verifyIfExists(id);

		return equipmentMapper.toDTO(equipment);
	}

	@Override
	public void delete(Long id) throws EquipmentNotFoundException {

		verifyIfExists(id);
		equipmentRepository.deleteById(id);
	}

	@Override
	public List<EquipmentResponseDTO> finAll() {
		return equipmentRepository.findAll().stream().map(equipmentMapper::toDTO).collect(Collectors.toList());
	}

	@Override
	public EquipmentResponseDTO update(Long id, EquipmentRequestDTO equipmentDTO) throws EquipmentNotFoundException {
		
		verifyIfExists(id);
		
		Equipment equipment = equipmentRepository.save(equipmentMapper.toModel(equipmentDTO));
	
		return equipmentMapper.toDTO(equipment);
	}

	private Equipment verifyIfExists(Long id) throws EquipmentNotFoundException {
		return equipmentRepository.findById(id).orElseThrow(() -> new EquipmentNotFoundException(id));
	}

}
