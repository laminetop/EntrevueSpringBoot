package com.example.entrevueSpringBoot.Modele.EmbededPK;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class FilmActeurPK implements Serializable {


    private static final long serialVersionUID = 1L;

    private Long idsite;

    private Long idformation;


}
