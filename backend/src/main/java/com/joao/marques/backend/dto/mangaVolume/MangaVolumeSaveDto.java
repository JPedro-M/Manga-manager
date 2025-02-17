package com.joao.marques.backend.dto.mangaVolume;

import lombok.Data;

@Data
public class MangaVolumeSaveDto {
	private String title;
	private Long number;
	private Long mangaId;
}
