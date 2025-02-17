package com.joao.marques.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.marques.backend.Exception.MangaNotFoundException;
import com.joao.marques.backend.Exception.MangaVolumeNotFoundException;
import com.joao.marques.backend.dto.mangaVolume.MangaVolumeResponseDto;
import com.joao.marques.backend.dto.mangaVolume.MangaVolumeSaveDto;
import com.joao.marques.backend.service.MangaVolumeService;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/manga-volume")
public class MangaVolumeController {
	@Autowired
	private MangaVolumeService mangaVolumeService;

	@GetMapping
	public List<MangaVolumeResponseDto> listAll() {
		return mangaVolumeService.listAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<MangaVolumeResponseDto> findById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(mangaVolumeService.findById(id));
		} catch (MangaVolumeNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<MangaVolumeResponseDto> save(@RequestBody MangaVolumeSaveDto mangaVolume) {
		return ResponseEntity.ok(mangaVolumeService.save(mangaVolume));
	}

	@PutMapping("/{id}")
	public ResponseEntity<MangaVolumeResponseDto> update(@PathVariable Long id,
			@RequestBody MangaVolumeSaveDto mangaVolume) {
		try {
			return ResponseEntity.ok(mangaVolumeService.update(id, mangaVolume));
		} catch (MangaVolumeNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (MangaNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		try {
			mangaVolumeService.delete(id);
			return ResponseEntity.ok().build();
		} catch (MangaVolumeNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
