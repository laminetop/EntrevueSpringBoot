package com.example.entrevueSpringBoot.DTO;

import com.example.entrevueSpringBoot.Modele.Acteur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ActeurDTO {

    private  Long id;

    private String nom;

    private String prenom;

    @JsonIgnore
    private List<FilmDTO> filmsDTO;

    public static ActeurDTO fromEntity(Acteur acteur) {
        if (acteur == null) {
            return null;
        }
        return ActeurDTO.builder()
                .nom(acteur.getNom())
                .prenom(acteur.getPrenom())
                .build();
    }
}
