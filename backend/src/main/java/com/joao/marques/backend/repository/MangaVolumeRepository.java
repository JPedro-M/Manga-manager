package com.joao.marques.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.marques.backend.entity.MangaVolume;

public interface MangaVolumeRepository extends JpaRepository<MangaVolume, Long> {
}