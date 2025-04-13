package com.joao.marques.backend.mapper;

import com.joao.marques.backend.dto.mangaVolume.MangaVolumeResponseDto;
import com.joao.marques.backend.dto.mangaVolume.MangaVolumeSaveDto;
import com.joao.marques.backend.entity.Manga;
import com.joao.marques.backend.entity.MangaVolume;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-13T18:41:25-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class MangaVolumeMapperImpl implements MangaVolumeMapper {

    @Override
    public MangaVolumeSaveDto toSaveDto(MangaVolume mangaVolume) {
        if ( mangaVolume == null ) {
            return null;
        }

        MangaVolumeSaveDto mangaVolumeSaveDto = new MangaVolumeSaveDto();

        mangaVolumeSaveDto.setMangaId( mangaVolumeMangaId( mangaVolume ) );
        mangaVolumeSaveDto.setTitle( mangaVolume.getTitle() );
        mangaVolumeSaveDto.setNumber( mangaVolume.getNumber() );

        return mangaVolumeSaveDto;
    }

    @Override
    public MangaVolumeResponseDto toResponseDto(MangaVolume mangaVolume) {
        if ( mangaVolume == null ) {
            return null;
        }

        MangaVolumeResponseDto mangaVolumeResponseDto = new MangaVolumeResponseDto();

        mangaVolumeResponseDto.setMangaId( mangaVolumeMangaId( mangaVolume ) );
        mangaVolumeResponseDto.setTitle( mangaVolume.getTitle() );
        mangaVolumeResponseDto.setNumber( mangaVolume.getNumber() );

        return mangaVolumeResponseDto;
    }

    @Override
    public MangaVolume toEntity(MangaVolumeSaveDto mangaVolume) {
        if ( mangaVolume == null ) {
            return null;
        }

        MangaVolume mangaVolume1 = new MangaVolume();

        mangaVolume1.setManga( mangaVolumeSaveDtoToManga( mangaVolume ) );
        mangaVolume1.setTitle( mangaVolume.getTitle() );
        mangaVolume1.setNumber( mangaVolume.getNumber() );

        return mangaVolume1;
    }

    @Override
    public MangaVolume toEntity(MangaVolumeResponseDto mangaVolume) {
        if ( mangaVolume == null ) {
            return null;
        }

        MangaVolume mangaVolume1 = new MangaVolume();

        mangaVolume1.setManga( mangaVolumeResponseDtoToManga( mangaVolume ) );
        mangaVolume1.setTitle( mangaVolume.getTitle() );
        mangaVolume1.setNumber( mangaVolume.getNumber() );

        return mangaVolume1;
    }

    private Long mangaVolumeMangaId(MangaVolume mangaVolume) {
        Manga manga = mangaVolume.getManga();
        if ( manga == null ) {
            return null;
        }
        return manga.getId();
    }

    protected Manga mangaVolumeSaveDtoToManga(MangaVolumeSaveDto mangaVolumeSaveDto) {
        if ( mangaVolumeSaveDto == null ) {
            return null;
        }

        Manga manga = new Manga();

        manga.setId( mangaVolumeSaveDto.getMangaId() );

        return manga;
    }

    protected Manga mangaVolumeResponseDtoToManga(MangaVolumeResponseDto mangaVolumeResponseDto) {
        if ( mangaVolumeResponseDto == null ) {
            return null;
        }

        Manga manga = new Manga();

        manga.setId( mangaVolumeResponseDto.getMangaId() );

        return manga;
    }
}
