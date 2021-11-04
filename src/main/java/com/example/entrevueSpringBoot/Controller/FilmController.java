package com.example.entrevueSpringBoot.Controller;

import com.example.entrevueSpringBoot.DTO.FilmDTO;
import com.example.entrevueSpringBoot.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/film")
public class FilmController {

    private FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService){
        this.filmService=filmService;
    }

    @GetMapping("/{id}")
    public FilmDTO getFilmById(@PathVariable("id") Long id) {
        return filmService.findById(id);
    }
    @PostMapping
    public FilmDTO createFilm(@RequestBody FilmDTO filmDTO){
            return filmService.save(filmDTO);
    }
}
