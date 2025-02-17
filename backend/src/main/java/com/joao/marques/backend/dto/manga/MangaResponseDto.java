package com.joao.marques.backend.dto.manga;

import lombok.Data;

@Data
public class MangaResponseDto {
	private Long id;
	private String title;
	private String author;
}
