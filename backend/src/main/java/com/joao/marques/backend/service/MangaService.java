package com.joao.marques.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.marques.backend.Exception.MangaNotFoundException;
import com.joao.marques.backend.dto.manga.MangaResponseDto;
import com.joao.marques.backend.dto.manga.MangaSaveDto;
import com.joao.marques.backend.entity.Manga;
import com.joao.marques.backend.mapper.MangaMapper;
import com.joao.marques.backend.repository.MangaRepository;

@Service
public class MangaService {
	@Autowired
	private MangaRepository mangaRepository;

	@Autowired
	private MangaMapper mangaMapper;

	public List<MangaResponseDto> listAll() {
		return mangaRepository.findAll().stream().map(mangaMapper::toResponseDto).toList();
	}

	public MangaResponseDto findById(Long id) {
		Optional<Manga> maybeManga = mangaRepository.findById(id);
		if (maybeManga.isEmpty()) {
			throw new MangaNotFoundException("Manga not found");
		}

		return mangaMapper.toResponseDto(maybeManga.get());
	}

	public MangaResponseDto save(MangaSaveDto mangaSaveDto) {
		Manga manga = mangaMapper.toEntity(mangaSaveDto);

		return mangaMapper.toResponseDto(mangaRepository.save(manga));
	}

	public MangaResponseDto update(Long id, MangaSaveDto mangaSaveDto) {
		Optional<Manga> maybeManga = mangaRepository.findById(id);
		if (maybeManga.isEmpty()) {
			throw new MangaNotFoundException("Manga not found");
		}
		Manga manga = maybeManga.get();

		if (mangaSaveDto.getTitle() != null) {
			manga.setTitle(mangaSaveDto.getTitle());
		}
		if (mangaSaveDto.getAuthor() != null) {
			manga.setAuthor(mangaSaveDto.getAuthor());
		}

		return mangaMapper.toResponseDto(mangaRepository.save(manga));
	}

	public void delete(Long id) {
		if (mangaRepository.findById(id).isEmpty()) {
			throw new MangaNotFoundException("Manga not found");
		}

		mangaRepository.deleteById(id);
	}
}
