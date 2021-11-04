package com.example.entrevueSpringBoot.DTO;


import com.example.entrevueSpringBoot.Modele.Film;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FilmDTO {
    private Long id;

    private String titre;

    private String description;

    private List<ActeurDTO> acteursDTO;

    public static FilmDTO fromEntity(Film film) {
        if (film == null) {
            return null;
        }
        return FilmDTO.builder()
                .id(film.getId())
                .titre(film.getTitre())
                .description(film.getDescription())
                .acteursDTO(
                        film.getActeurs() != null ?
                                film.getActeurs()
                                        .stream()
                                        .map(ActeurDTO::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static Film toEntity(FilmDTO filmDTO) {
        if (filmDTO == null) {
            return null;
        }
        Film film = new Film();
        film.setId(filmDTO.getId());
        film.setTitre(filmDTO.getTitre());
        film.setDescription(filmDTO.getDescription());
        return film;
    }
}
