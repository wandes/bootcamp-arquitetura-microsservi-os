package br.com.equipment.dto.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipmentResponseDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private Integer amount;

	@Override
	public String toString() {
		return "EquipmentResponseDTO [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}
	
}
