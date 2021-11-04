package com.example.entrevueSpringBoot.Service;

import com.example.entrevueSpringBoot.DTO.FilmDTO;
import com.example.entrevueSpringBoot.Exception.EntityNotFoundException;
import com.example.entrevueSpringBoot.Exception.ErrorCodes;
import com.example.entrevueSpringBoot.Modele.Acteur;
import com.example.entrevueSpringBoot.Modele.EmbededPK.FilmActeurPK;
import com.example.entrevueSpringBoot.Modele.Film;
import com.example.entrevueSpringBoot.Modele.FilmsJoues;
import com.example.entrevueSpringBoot.Repository.ActeurRepositoty;
import com.example.entrevueSpringBoot.Repository.FilmRepostory;
import com.example.entrevueSpringBoot.Repository.FilmsJouesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FilmServiceImpl implements FilmService{


    private FilmRepostory filmRepository;
    private ActeurRepositoty acteurRepository;
    private FilmsJouesRepository filmsJouesRepository;
    @Autowired
    public FilmServiceImpl( FilmRepostory filmRepository, ActeurRepositoty acteurRepository,
                            FilmsJouesRepository filmsJouesRepository){
        this.filmRepository=filmRepository;
        this.acteurRepository=acteurRepository;
        this.filmsJouesRepository=filmsJouesRepository;
    }

    @Override
    public FilmDTO findById(Long id) {
        if (id == null) {
            log.error("Film is is not found");
            return null;
        }
        return filmRepository.findById(id)
                .map(FilmDTO::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun Film avec l'id = " + id + " n' ete trouve",
                        ErrorCodes.SITE_NOT_FOUND)
                );
    }

    @Override
    public FilmDTO save(FilmDTO filmDTO) {
        List<String> acteursErrors = new ArrayList<>();
        System.out.println("------------------------------------"+filmDTO.getActeursDTO());
        Film film = filmRepository.save(FilmDTO.toEntity(filmDTO));
        if (filmDTO.getActeursDTO() != null) {
            filmDTO.getActeursDTO().forEach(acteurs -> {
                if (acteurs != null) {
                    Optional<Acteur> acteur = acteurRepository.findById(acteurs.getId());
                    if (acteur.isEmpty()) {
                        acteursErrors.add("L'acteur avec l'ID " +acteurs.getId() + " n'existe pas");
                    }
                    FilmsJoues filmsJoues = new FilmsJoues(new FilmActeurPK(film.getId(),acteur.get().getId()),film, acteur.get());
                    filmsJouesRepository.save(filmsJoues);
                } else {
                    acteursErrors.add("Impossible d'enregister un film avec une formation nulle");
                }
            });
        }
        return FilmDTO.fromEntity(film);
    }
}
