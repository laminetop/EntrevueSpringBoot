package com.example.entrevueSpringBoot.Repository;

import com.example.entrevueSpringBoot.Modele.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurRepositoty extends JpaRepository<Acteur,Long> {
}
