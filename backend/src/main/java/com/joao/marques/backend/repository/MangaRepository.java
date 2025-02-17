package com.joao.marques.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.marques.backend.entity.Manga;

public interface MangaRepository extends JpaRepository<Manga, Long> {
}
