package com.joao.marques.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.marques.backend.Exception.MangaNotFoundException;
import com.joao.marques.backend.dto.manga.MangaResponseDto;
import com.joao.marques.backend.dto.manga.MangaSaveDto;
import com.joao.marques.backend.service.MangaService;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/manga")
public class MangaController {
	@Autowired
	private MangaService mangaService;

	@GetMapping
	public List<MangaResponseDto> listAll() {
		return mangaService.listAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<MangaResponseDto> findById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(mangaService.findById(id));
		} catch (MangaNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<MangaResponseDto> save(@RequestBody MangaSaveDto manga) {
		return ResponseEntity.ok(mangaService.save(manga));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<MangaResponseDto> partialUpdate(@PathVariable Long id, @RequestBody MangaSaveDto manga) {
		try {
			return ResponseEntity.ok(mangaService.update(id, manga));
		} catch (MangaNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		try {
			mangaService.delete(id);
			return ResponseEntity.ok().build();
		} catch (MangaNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}