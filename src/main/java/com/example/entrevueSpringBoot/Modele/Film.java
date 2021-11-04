package com.example.entrevueSpringBoot.Modele;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "Film")
public class Film  implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String titre;

    private String description;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "FilmsJoues",
            joinColumns = { @JoinColumn(name = "idFilm") },
            inverseJoinColumns = { @JoinColumn(name = "idActeur") }
    )
    private List<Acteur> acteurs;


}
