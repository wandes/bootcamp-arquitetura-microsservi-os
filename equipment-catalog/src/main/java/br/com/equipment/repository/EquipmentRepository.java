package br.com.equipment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.equipment.model.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long>{

}
