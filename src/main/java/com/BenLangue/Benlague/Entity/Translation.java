package com.BenLangue.Benlague.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Traduction")
public class Translation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Expressions expression;

    @ManyToOne(optional = false)
    private  Language language;

    @Column(nullable = false)
    private String texte;

    @OneToOne(mappedBy = "translation", cascade = CascadeType.ALL, orphanRemoval = true)
    private AudioFile audioFile;

    /*
    Cette classe représente la table translation de la base de données pour permettre les différentes translations que
    plateforme peut satisfaire
     */

}
