package com.joao.marques.backend.dto.mangaVolume;

import lombok.Data;

@Data
public class MangaVolumeResponseDto {
	private String title;
	private Long number;
	private Long mangaId;
}
