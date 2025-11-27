package com.BenLangue.Benlague.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TraductionRequest {

    private String texte;
    private String sourceLangue;
    private String directionLangue;
}
