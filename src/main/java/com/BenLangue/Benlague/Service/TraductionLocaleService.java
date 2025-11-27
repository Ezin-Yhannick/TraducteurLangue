package com.BenLangue.Benlague.Service;

import com.BenLangue.Benlague.DTOs.TraductionReponse;
import com.BenLangue.Benlague.DTOs.TraductionRequest;
import com.BenLangue.Benlague.Entity.AudioFile;
import com.BenLangue.Benlague.Entity.Language;
import com.BenLangue.Benlague.Entity.Translation;
import com.BenLangue.Benlague.Repository.AudioFileRepository;
import com.BenLangue.Benlague.Repository.LanguageRepository;
import com.BenLangue.Benlague.Repository.TraductionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TraductionLocaleService {

    private final LanguageRepository languageRepository;
    private final TraductionRepository traductionRepository;
    private final AudioFileRepository audioFileRepository;

    public TraductionReponse traductionReponse(TraductionRequest traductionRequest){

        String srcCode = traductionRequest.getSourceLangue().toLowerCase();
        String tgtCode = traductionRequest.getDirectionLangue().toLowerCase();

        Language srcLangue = languageRepository.findByCode(srcCode)
                .orElseThrow(() -> new RuntimeException("Langue source inconnue : " + srcCode));

        Language tgtLangue = languageRepository.findByCode(tgtCode)
                .orElseThrow(() -> new RuntimeException("Langue cible inconnue " + tgtCode ));

        //Commande pour chercher la traduction source
        Optional<Translation> srcTranslationOpt = traductionRepository
                .findByLanguageAndTexteIgnoreCase(srcLangue, traductionRequest.getTexte());

        if(srcTranslationOpt.isEmpty()){
            return new TraductionReponse(
                    traductionRequest.getTexte(),
                    srcCode,
                    tgtCode,
                    "Pas encore disponible cette traduction",
                    null
            );
        }

        Translation srcTranslation = srcTranslationOpt.get();

        var tgtTranslations = traductionRepository
                .findByExpressionAndLanguage(srcTranslation.getExpression(), tgtLangue);

        String textetraduit = tgtTranslations.isEmpty()?
                "Pas encore de traduction disponible" :
                tgtTranslations.get(0).getTexte();

        // ...
        String audioUrl = null;
        if(!tgtTranslations.isEmpty()) {

            // 1. On récupère directement l'objet AudioFile
            AudioFile audio = tgtTranslations.get(0).getAudioFile();

            // 2. On vérifie s'il n'est pas null
            if (audio != null) {
                // 3. On affecte audioUrl si l'objet existe
                audioUrl = "/media" + audio.getFilepath();
            }
        }
// ...

        return new TraductionReponse(
                traductionRequest.getTexte(),
                srcCode,
                tgtCode,
                textetraduit,
                audioUrl
        );
    }

}
