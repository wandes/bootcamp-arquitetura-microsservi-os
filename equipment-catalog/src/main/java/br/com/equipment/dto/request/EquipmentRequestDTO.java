package br.com.equipment.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class EquipmentRequestDTO {

	private Long id;
	
	@NotEmpty
	@Size(min = 1, max = 100)
	private String name;
	
	@NotNull
	private Integer amount;

	@Override
	public String toString() {
		return "EquipmentRequestDTO [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}
	
	
}