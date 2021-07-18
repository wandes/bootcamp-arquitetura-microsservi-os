package br.com.equipment.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.equipment.dto.request.EquipmentRequestDTO;
import br.com.equipment.dto.response.EquipmentResponseDTO;
import br.com.equipment.exception.EquipmentNotFoundException;
import br.com.equipment.service.impl.EquipmentServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/v1/equipment")
@Log4j2
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EquipmentController {

	private EquipmentServiceImpl service;
	
	@ApiOperation(value = "Cadastra um equipamento")
	@PostMapping
	public ResponseEntity<EquipmentResponseDTO> create(@RequestBody @Valid EquipmentRequestDTO equipmentDTO) {

		URI locationResource = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(equipmentDTO.getId()).toUri();

		EquipmentResponseDTO response = service.create(equipmentDTO);

		log.info("Cadastrando equipamento " + equipmentDTO);

		return ResponseEntity.created(locationResource).body(response);
	}
	
	@ApiOperation(value = "Localiza equipamento por id")
	@GetMapping("/{id}")
	public ResponseEntity<EquipmentResponseDTO> findById(@PathVariable Long id) throws EquipmentNotFoundException {
		
		log.info("Pesquisando equipamento de id " + id);
		
		return ResponseEntity.ok(service.findById(id));
	}
	
	@ApiOperation(value = "Exclui equipamento")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) throws EquipmentNotFoundException {
		
		log.info("Deletando equipamento de id " + id);
		
		service.delete(id);

		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Atualiza equipamento")
	@PutMapping("/{id}")
	public ResponseEntity<EquipmentResponseDTO> update(@PathVariable Long id, @RequestBody @Valid EquipmentRequestDTO equipmentDTO)
			throws EquipmentNotFoundException {
		
		log.info("Atualizando equipamento " + equipmentDTO);
		
		return ResponseEntity.status(HttpStatus.valueOf(201)).body(service.update(id, equipmentDTO));
	}
	
	@ApiOperation(value = "Lista todos os equipamentos")
	@GetMapping
	public ResponseEntity<List<EquipmentResponseDTO>> findAll() {
		log.info("Listando todos os equipamentos ");
		return ResponseEntity.ok(service.finAll());
	}
}
