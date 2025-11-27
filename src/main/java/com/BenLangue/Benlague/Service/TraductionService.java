package com.BenLangue.Benlague.Service;

import com.BenLangue.Benlague.DTOs.TraductionReponse;
import com.BenLangue.Benlague.DTOs.TraductionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class TraductionService {

    private final TraductionLocaleService localeService;
    private final TraductionExterneService externeService;
    private final HistoriqueService historiqueService;

    public TraductionReponse traductionReponse(TraductionRequest traductionRequest){

        String src = traductionRequest.getSourceLangue().toLowerCase();
        String tgt = traductionRequest.getDirectionLangue().toLowerCase();

        TraductionReponse response;

        //Cas de l'utilisation d'un API pour la traduction
        if ((src.equals("en") && tgt.equals("fr")) || (src.equals("fr") && tgt.equals("en"))){

            String traduit = externeService.traductionWithApi(traductionRequest.getTexte(), src, tgt);

            response = new TraductionReponse(
                    traductionRequest.getTexte(),
                    src,
                    tgt,
                    traduit,
                    null
            );
        }else {
            //Cas locaux
            response = localeService.traductionReponse(traductionRequest);
        }

        //Sauvegarde dans l'historique
        historiqueService.saveHistorique(
                null,
                traductionRequest.getTexte(),
                src,
                tgt,
                response.getTexteTraduit()
        );

        return  response;

    }

}
