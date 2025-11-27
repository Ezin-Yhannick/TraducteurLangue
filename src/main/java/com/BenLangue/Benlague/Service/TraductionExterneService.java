package com.BenLangue.Benlague.Service;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TraductionExterneService {

    private final WebClient.Builder webClientBuilder;


    private String apikey;

    public String traductionWithApi(String texte, String source, String direction){
        try {
            WebClient client = webClientBuilder
                    .baseUrl("https://translation.googleapis.com/language/translate/v2")
                    .build();

            Map reponse = client.post()
                    .uri(uriBuilder -> uriBuilder.queryParam("key",apikey).build())
                    .bodyValue(Map.of(
                            "q", texte,
                            "source", source,
                            "target", direction,
                            "format", "text"
                    ))
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            Map donnees = (Map) reponse.get("data");
            Map traduction = (Map) ((List) donnees.get("translations")).get(0);

            return traduction.get("textetraduit").toString();
        } catch (Exception e) {
            return "Erreur API !: " + e.getMessage();
        }

    }
}
