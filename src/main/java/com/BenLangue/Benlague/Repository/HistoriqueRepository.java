package com.BenLangue.Benlague.Repository;

import com.BenLangue.Benlague.Entity.Historique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoriqueRepository extends JpaRepository<Historique, Long> {

    //Recuperer l(historique d'un utilisateur
    List<Historique> findByUserId(String userId);

    //Récupérer l'historique complet par ordre décroissant
    List<Historique> findAllByOrderByTimestampDesc();
}
