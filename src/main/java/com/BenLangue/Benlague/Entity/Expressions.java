package com.BenLangue.Benlague.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expressions {

    @Id @GeneratedValue
    private Long id;

    private boolean isPhrase;

    private String contexte;

    @OneToMany(mappedBy = "expression", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Translation> translations = new ArrayList<>();
/*
     Table de la base de données qui va contenir les expressions les plus courantes qu'on aura à utiliser,
     les expressions seront soit en fon ou en yoruba , avec leur équivalence en français/anglais
 */
}

