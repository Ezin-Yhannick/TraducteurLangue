package com.BenLangue.Benlague.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TraductionReponse {
    private String sourceTexte;
    private String sourceLangue;
    private String directionLangue;
    private String TexteTraduit;
    private String audioUrl; //Juste si disponible
}
