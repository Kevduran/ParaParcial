package com.kevinduran.parcial2.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SongDto {
	@NotEmpty
	private String title;
	
	@NotEmpty
	private Integer duration;
}
