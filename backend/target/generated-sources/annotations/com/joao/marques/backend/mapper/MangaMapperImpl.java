package com.joao.marques.backend.mapper;

import com.joao.marques.backend.dto.manga.MangaResponseDto;
import com.joao.marques.backend.dto.manga.MangaSaveDto;
import com.joao.marques.backend.entity.Manga;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-13T18:47:33-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.v20250409-1823, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class MangaMapperImpl implements MangaMapper {

    @Override
    public MangaSaveDto toSaveDto(Manga manga) {
        if ( manga == null ) {
            return null;
        }

        MangaSaveDto mangaSaveDto = new MangaSaveDto();

        mangaSaveDto.setAuthor( manga.getAuthor() );
        mangaSaveDto.setTitle( manga.getTitle() );

        return mangaSaveDto;
    }

    @Override
    public MangaResponseDto toResponseDto(Manga manga) {
        if ( manga == null ) {
            return null;
        }

        MangaResponseDto mangaResponseDto = new MangaResponseDto();

        mangaResponseDto.setAuthor( manga.getAuthor() );
        mangaResponseDto.setId( manga.getId() );
        mangaResponseDto.setTitle( manga.getTitle() );

        return mangaResponseDto;
    }

    @Override
    public Manga toEntity(MangaSaveDto manga) {
        if ( manga == null ) {
            return null;
        }

        Manga manga1 = new Manga();

        manga1.setAuthor( manga.getAuthor() );
        manga1.setTitle( manga.getTitle() );

        return manga1;
    }

    @Override
    public Manga toEntity(MangaResponseDto manga) {
        if ( manga == null ) {
            return null;
        }

        Manga manga1 = new Manga();

        manga1.setAuthor( manga.getAuthor() );
        manga1.setId( manga.getId() );
        manga1.setTitle( manga.getTitle() );

        return manga1;
    }
}
