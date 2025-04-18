package com.example.controle.repository;

import com.example.controle.model.Campagne;
import com.example.controle.projection.CampagneResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CampagneRepository extends JpaRepository<Campagne, Long> {
    @Query("SELECT c.id as id, c.nom as nom, c.objectifMontant as objectifMontant FROM Campagne c WHERE c.dateDebut <= :date AND c.dateFin >= :date")
    List<CampagneResume> findActiveCampagnes(LocalDate date);
    
    Optional<Campagne> findByNom(String nom);
} 