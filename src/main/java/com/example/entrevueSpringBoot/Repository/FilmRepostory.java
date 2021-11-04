package com.example.entrevueSpringBoot.Repository;

import com.example.entrevueSpringBoot.Modele.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepostory  extends JpaRepository<Film,Long> {
}
