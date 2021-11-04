package com.example.entrevueSpringBoot.Repository;

import com.example.entrevueSpringBoot.Modele.EmbededPK.FilmActeurPK;
import com.example.entrevueSpringBoot.Modele.FilmsJoues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmsJouesRepository extends JpaRepository<FilmsJoues, FilmActeurPK> {
}
