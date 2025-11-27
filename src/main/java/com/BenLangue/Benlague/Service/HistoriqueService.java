package com.BenLangue.Benlague.Service;

import com.BenLangue.Benlague.Entity.Historique;
import com.BenLangue.Benlague.Repository.HistoriqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoriqueService {

    private final HistoriqueRepository historiqueRepository;

    public void saveHistorique(String userId, String sourcetexte, String sourcelang, String targetlang, String textetraduit){
        Historique historique = new Historique();
        historique.setUserId(userId);
        historique.setSourceTexte(sourcetexte);
        historique.setSourceLangue(sourcelang);
        historique.setDestinationLangue(targetlang);
        historique.setTimestamp(LocalDateTime.now());
        historiqueRepository.save(historique);
    }

    public List<Historique> getAllHistorique(){
        return historiqueRepository.findAllByOrderByTimestampDesc();
    }
    public List<Historique> getUserHistorique(String userId){
        return historiqueRepository.findByUserId(userId);
    }
}
