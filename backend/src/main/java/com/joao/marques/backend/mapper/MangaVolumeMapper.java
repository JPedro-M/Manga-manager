package com.joao.marques.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.joao.marques.backend.dto.mangaVolume.MangaVolumeResponseDto;
import com.joao.marques.backend.dto.mangaVolume.MangaVolumeSaveDto;
import com.joao.marques.backend.entity.MangaVolume;

@Mapper(componentModel = "spring")
public interface MangaVolumeMapper {
	MangaVolumeMapper INSTANCE = Mappers.getMapper(MangaVolumeMapper.class);

	@Mapping(source = "manga.id", target = "mangaId")
	MangaVolumeSaveDto toSaveDto(MangaVolume mangaVolume);

	@Mapping(source = "manga.id", target = "mangaId")
	MangaVolumeResponseDto toResponseDto(MangaVolume mangaVolume);

	@Mapping(source = "mangaId", target = "manga.id")
	@Mapping(target = "id", ignore = true)
	MangaVolume toEntity(MangaVolumeSaveDto mangaVolume);

	@Mapping(source = "mangaId", target = "manga.id")
	@Mapping(target = "id", ignore = true)
	MangaVolume toEntity(MangaVolumeResponseDto mangaVolume);

}
