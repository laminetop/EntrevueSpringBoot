package com.example.entrevueSpringBoot.Service;

import com.example.entrevueSpringBoot.DTO.FilmDTO;

public interface FilmService {

    FilmDTO findById(Long id);
    FilmDTO save (FilmDTO filmDTO);
}
