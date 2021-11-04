package com.example.entrevueSpringBoot.Modele;

import com.example.entrevueSpringBoot.Modele.EmbededPK.FilmActeurPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "FilmsJoues")
public class FilmsJoues implements Serializable {


    @EmbeddedId
    private FilmActeurPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFilm",nullable = false ,insertable = false, updatable = false)
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idActeur", nullable = false ,insertable = false, updatable = false)
    private Acteur acteur;

}
