package com.joao.marques.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.joao.marques.backend.dto.manga.MangaResponseDto;
import com.joao.marques.backend.dto.manga.MangaSaveDto;
import com.joao.marques.backend.entity.Manga;

@Mapper(componentModel = "spring")
public interface MangaMapper {
	MangaSaveDto toSaveDto(Manga manga);

	MangaResponseDto toResponseDto(Manga manga);

	@Mapping(target = "volumes", ignore = true)
	@Mapping(target = "id", ignore = true)
	Manga toEntity(MangaSaveDto manga);

	@Mapping(target = "volumes", ignore = true)
	Manga toEntity(MangaResponseDto manga);
}
