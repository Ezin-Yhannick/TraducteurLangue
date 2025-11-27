package com.BenLangue.Benlague.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Historiques")
public class Historique {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String sourceTexte;

    private String sourceLangue;

    private String destinationLangue;

    private String texteTraduit;

    private LocalDateTime timestamp = LocalDateTime.now();
}
