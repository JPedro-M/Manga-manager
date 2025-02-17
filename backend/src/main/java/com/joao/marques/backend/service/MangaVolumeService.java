package com.joao.marques.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.marques.backend.Exception.MangaNotFoundException;
import com.joao.marques.backend.Exception.MangaVolumeNotFoundException;
import com.joao.marques.backend.dto.mangaVolume.MangaVolumeResponseDto;
import com.joao.marques.backend.dto.mangaVolume.MangaVolumeSaveDto;
import com.joao.marques.backend.entity.Manga;
import com.joao.marques.backend.entity.MangaVolume;
import com.joao.marques.backend.mapper.MangaVolumeMapper;
import com.joao.marques.backend.repository.MangaRepository;
import com.joao.marques.backend.repository.MangaVolumeRepository;

@Service
public class MangaVolumeService {
	@Autowired
	private MangaVolumeRepository mangaVolumeRepository;
	@Autowired
	private MangaVolumeMapper mangaVolumeMapper;
	@Autowired
	private MangaRepository mangaRepository;

	public List<MangaVolumeResponseDto> listAll() {
		return mangaVolumeRepository.findAll().stream().map(mangaVolumeMapper::toResponseDto).toList();
	}

	public MangaVolumeResponseDto findById(Long id) {
		Optional<MangaVolume> maybeMangaVolume = mangaVolumeRepository.findById(id);
		if (maybeMangaVolume.isEmpty()) {
			throw new MangaVolumeNotFoundException("Manga Volume not found");
		}

		return mangaVolumeMapper.toResponseDto(maybeMangaVolume.get());
	}

	public MangaVolumeResponseDto save(MangaVolumeSaveDto mangaVolumeSaveDto) {
		MangaVolume mangaVolume = mangaVolumeMapper.toEntity(mangaVolumeSaveDto);

		return mangaVolumeMapper.toResponseDto(mangaVolumeRepository.save(mangaVolume));
	}

	public MangaVolumeResponseDto update(Long id, MangaVolumeSaveDto mangaVolumeSaveDto) {
		Optional<MangaVolume> maybeMangaVolume = mangaVolumeRepository.findById(id);

		if (maybeMangaVolume.isEmpty()) {
			throw new MangaVolumeNotFoundException("Manga Volume not found");
		}
		MangaVolume mangaVolume = maybeMangaVolume.get();

		if (mangaVolumeSaveDto.getTitle() != null) {
			mangaVolume.setTitle(mangaVolumeSaveDto.getTitle());
		}
		if (mangaVolumeSaveDto.getNumber() != null) {
			mangaVolume.setNumber(mangaVolumeSaveDto.getNumber());
		}
		if (mangaVolumeSaveDto.getMangaId() != null) {
			Optional<Manga> maybeManga = mangaRepository.findById(mangaVolumeSaveDto.getMangaId());

			if (maybeManga.isEmpty()) {
				throw new MangaNotFoundException("Manga not found");
			}

			mangaVolume.setManga(maybeManga.get());
		}

		return mangaVolumeMapper.toResponseDto(mangaVolumeRepository.save(mangaVolume));
	}

	public void delete(Long id) {
		Optional<MangaVolume> maybeMangaVolume = mangaVolumeRepository.findById(id);

		if (maybeMangaVolume.isEmpty()) {
			throw new MangaVolumeNotFoundException("Manga Volume not found");
		}

		mangaVolumeRepository.deleteById(id);
	}
}
